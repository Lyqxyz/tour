package com.tour.app.controller;

import com.tour.app.model.entity.Email;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.EmailMapper;
import com.tour.app.untils.ReponseUtil;
import com.tour.app.untils.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("/email")
public class EmailController {


    @Autowired
    EmailMapper emailMapper;

    @Autowired
    JavaMailSender javaMailSender;

    @ResponseBody
    @PostMapping("/send")
    public Object send(@RequestParam("email") String email){

        Email has = emailMapper.has(email);

        if(Objects.isNull(has)){

            Email email1 = new Email();

            Random random = new Random();

            int i = random.nextInt(100000);

            String text = "你的验证码是:"+i+"<<请尽快注册，以免失效>>";


            try {

                SendMailUtil.send(email,"注册验证码",text,javaMailSender);
            }
            catch (Exception e){

                ResponseInfo error = ReponseUtil.error();

                error.setMsg("邮箱不正确");

                return error;

            }

            email1.setCode(i+"");

            email1.setEmail(email);

            email1.setCreated(System.currentTimeMillis());

            email1.setModify(System.currentTimeMillis());

            emailMapper.add(email1);

        }else{
            Email email1 = new Email();

            email1.setEmail(email);

            Random random = new Random();

            int i = random.nextInt(10000);

            String text = "你的验证码是:"+i+"<<请尽快注册.以免失效!!!>>";

            try {
                SendMailUtil.send(email,"注册验证码",text,javaMailSender);
            }catch (Exception e){

                ResponseInfo error = ReponseUtil.error();

                error.setMsg("邮箱不正确");

                return error;

            }


            email1.setCode(i+"");

            email1.setModify(System.currentTimeMillis());

            emailMapper.update(email1);

        }

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("验证码已发送至邮箱");

        return ok;

    }
}
