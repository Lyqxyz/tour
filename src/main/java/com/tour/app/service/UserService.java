package com.tour.app.service;

import com.tour.app.model.entity.Email;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.EmailMapper;
import com.tour.app.model.mapper.UserMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.ws.ServiceMode;
import java.util.Date;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailMapper emailMapper;

    public ResponseInfo login(Users users, HttpSession session){


        users.setPwd(users.getPwd().trim());
        users.setEmail(users.getEmail().trim());

        Users login = userMapper.login(users);

        if(Objects.isNull(login)){

            return ReponseUtil.error();
        }

        session.setAttribute("user",login);

        ResponseInfo ok = ReponseUtil.ok();

        ok.getInfo().put("data",login);
        return ok;
    }

    public ResponseInfo updatePwd(Users users){


        Integer integer = userMapper.updatePwd(users);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("密码修改成功");


        return ok;
    }


    public ResponseInfo reg(Users users,String code){

        Users check = userMapper.checkEmail(users.getEmail());

        Users users1 = userMapper.checkPhone(users.getPhone());

        if(check!=null){

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("邮箱已经被注册了");

            return error;
        }

        if(users1!=null){


            ResponseInfo error = ReponseUtil.error();

            error.setMsg("电话已经被注册了");

            return error;
        }

        Email has = emailMapper.has(users.getEmail());


        if(Objects.isNull(has)){

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("你还没有点发送验证码");

            return error;
        }

        Long modify = has.getModify();

        long time = System.currentTimeMillis();
        long a = time-modify;
        System.out.println(a);
        if(time-modify>300*1000){

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("验证码无效");

            return error;
        }

        Email email = new Email();

        email.setEmail(users.getEmail());

        email.setCode(code);

        Email check1 = emailMapper.check(email);

        if(Objects.isNull(check1)){

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("验证码错误");

            return error;
        }else{

            users.setPwd(users.getPwd().trim());

            users.setEmail(users.getEmail().trim());

            Integer reg = userMapper.reg(users);

            ResponseInfo ok = ReponseUtil.ok();

            ok.setMsg("注册成功");

            return ok;

        }


    }


}
