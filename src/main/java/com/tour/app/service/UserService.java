package com.tour.app.service;

import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.UserMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ResponseInfo login(Users users){

        Users login = userMapper.login(users);

        if(Objects.isNull(login)){

            return ReponseUtil.error();
        }

        return ReponseUtil.ok();
    }

    public ResponseInfo reg(Users users){

        Users check = userMapper.check(users.getUsername());

        if(Objects.isNull(check)){

            Integer reg = userMapper.reg(users);
            ResponseInfo ok = ReponseUtil.ok();
            ok.setMsg("注册成功");

            return ok;
        }else {

            ResponseInfo error = ReponseUtil.error();
            error.setMsg("用户已被注册");

            return error;
        }

    }


}
