package vn.khahhann.musicyoutubebackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.Role;
import vn.khahhann.musicyoutubebackend.entity.User;
import vn.khahhann.musicyoutubebackend.repository.RoleRepository;
import vn.khahhann.musicyoutubebackend.repository.UserRepository;
import vn.khahhann.musicyoutubebackend.service.UserService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findUserByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Not found user!");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), rolesToAuthorities(user.getRoleList()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
