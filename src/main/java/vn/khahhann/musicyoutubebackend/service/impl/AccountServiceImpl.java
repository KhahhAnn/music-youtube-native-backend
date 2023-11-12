package vn.khahhann.musicyoutubebackend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.Notify;
import vn.khahhann.musicyoutubebackend.entity.Role;
import vn.khahhann.musicyoutubebackend.entity.User;
import vn.khahhann.musicyoutubebackend.repository.RoleRepository;
import vn.khahhann.musicyoutubebackend.repository.UserRepository;
import vn.khahhann.musicyoutubebackend.service.AccountService;
import vn.khahhann.musicyoutubebackend.service.EmailService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private EmailService emailService;
    private RoleRepository roleRepository;
    @Override
    public ResponseEntity<?> register(User user) {
        if(this.userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new Notify("Email đã tồn tại"));
        }
        if (user.getPassword() == null) {
            System.out.println("Mật khẩu không thể là null");
            return ResponseEntity.badRequest().body(new Notify("Mật khẩu không thể là null"));
        }
        String encryptPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptPassword);
        user.setActivationCode(createActivationCode());
        user.setActive(false);
        user.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fvietnamnet.vn%2Fdan-mang-du-trend-facebook-doi-avatar-thanh-mat-trang-i63266.html&psig=AOvVaw1HFy0JwdZlCCZSS8ip4mtt&ust=1699617920128000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPDB6qbwtoIDFQAAAAAdAAAAABAE");
        List<Role> defaultRoles = roleRepository.findByRoleName("ROLE_USER");
        user.setRoleList(defaultRoles);
        User newUser = this.userRepository.saveAndFlush(user);
        sendMailActivationCode(user.getEmail(), user.getActivationCode());
        return ResponseEntity.ok("Đăng ký thành công");
    }

    @Override
    public String createActivationCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void sendMailActivationCode(String email, String activationCode) {
        String subject = "Kích hoạt tài khoản của bạn tại MusicApp";
        String text = "Vui lòng sử dụng đoạn mã sau để kích hoạt tài khoản < " + email + ">:<html><body><br/><h1>"+ activationCode +"</h1></body></html>";
        text+= "<br/> Click vào link để kích hoạt tài khoản: ";
        String url = "http://localhost:8080/account/active/"+ email + "/" + activationCode;
        text+= ("<br/> <a href="+url+">"+ url +"</a>");
        this.emailService.sendEmail("khanhanbui2003@gmail.com", email, subject, text);
    }

    @Override
    public ResponseEntity<?> activeAccount(String email, String activationCode) {
        User user = this.userRepository.findByEmail(email);
        if(user == null) {
            return ResponseEntity.badRequest().body(new Notify("Người dùng không tồn tại"));
        }
        if(user.isActive()) {
            return ResponseEntity.badRequest().body(new Notify("Tài khoản đã được kích hoạt!"));
        }
        if(activationCode.equals(user.getActivationCode())) {
            user.setActive(true);
            this.userRepository.save(user);
            return ResponseEntity.ok("Kích hoạt thành công!");
        } else {
            return ResponseEntity.badRequest().body(new Notify("Mã kích hoạt không chính xác!"));
        }
    }

    @Override
    public ResponseEntity<?> signIn(User user) {
        User existsUser = this.userRepository.findByEmail(user.getEmail());
        if (existsUser == null || !passwordEncoder.matches(user.getPassword(), existsUser.getPassword())) {
            return ResponseEntity.badRequest().body(new Notify("Tài khoản hoặc mật khẩu sai!"));
        }
        if (!existsUser.isActive()) {
            return ResponseEntity.badRequest().body(new Notify("Tài khoản chưa được kích hoạt!"));
        }
        return ResponseEntity.ok("Đăng nhập thành công!");
    }

}
