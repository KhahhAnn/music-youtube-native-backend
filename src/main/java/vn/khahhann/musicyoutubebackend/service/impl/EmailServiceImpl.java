package vn.khahhann.musicyoutubebackend.service.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.khahhann.musicyoutubebackend.service.EmailService;


@Service
public class EmailServiceImpl implements EmailService {
    private JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    public void sendEmail(String from, String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        this.mailSender.send(message);
    }
}
