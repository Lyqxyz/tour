package com.tour.app.untils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendMailUtil {

    public static void send(String to,String subject, String text, JavaMailSender javaMailSender){

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(to);

        mailMessage.setFrom("951384850@qq.com");

        mailMessage.setSubject(subject);

        mailMessage.setText(text);

        javaMailSender.send(mailMessage);

    }
}
