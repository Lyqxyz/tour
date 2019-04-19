package com.tour.app;

import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){

        List<Users> all = userMapper.all();

        System.out.println(all);

    }
}
