package vn.khahhann.musicyoutubebackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.User;

import java.util.UUID;

@Service
public interface AccountService {
    public ResponseEntity<?> register(User user);

    public String createActivationCode();

    public void sendMailActivationCode(String email, String activationCode);

    public ResponseEntity<?> activeAccount(String email, String activationCode);

    public ResponseEntity<?> signIn(User user);
}
