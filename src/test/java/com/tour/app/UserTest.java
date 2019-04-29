package com.tour.app;

import com.tour.app.model.entity.Email;
import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.EmailMapper;
import com.tour.app.model.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailMapper emailMapper;

    @Test
    public void test(){

        Email email = new Email();

        email.setCode("13245");

        long time = new Date().getTime();

        email.setCreated(time);

        email.setModify(time);

        email.setEmail("aaa@qq.com");

        emailMapper.add(email);

    }
}
