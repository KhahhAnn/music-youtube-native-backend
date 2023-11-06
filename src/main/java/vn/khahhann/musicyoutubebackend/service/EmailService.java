package vn.khahhann.musicyoutubebackend.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService  {
    public void sendEmail(String from, String to, String subject, String text);
}
