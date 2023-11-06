package vn.khahhann.musicyoutubebackend.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.entity.User;

@Service
public interface UserService extends UserDetailsService {
    public User findUserByEmail(String email);
}
