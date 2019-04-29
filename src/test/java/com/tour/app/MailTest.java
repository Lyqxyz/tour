package com.tour.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    JavaMailSender jms;

    @Test
    public void test(){

        Random random = new Random();
        int i = random.nextInt(100000);
        System.out.println(i);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        #ilngavjrwfefdjjf
        mailMessage.setTo("lu951384850@163.com");

        mailMessage.setFrom("951384850@qq.com");

        mailMessage.setSubject("注册验证码");

        mailMessage.setText("你的验证码是:"+i+"<<==>>5分钟内有效,请尽快注册!");

        jms.send(mailMessage);

    }
}
