package com.tour.app.model.mapper;

import com.tour.app.model.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

     List<Users> all();

     Users login(Users users);

     Integer reg(Users users);

     Users check(String usename);

     Integer updatePwd(Users users);

     Integer updatePic(Users users);

     Integer toAdmin(Integer uid);

     Integer del(Integer id);

     Users checkEmail(String email);

     Users checkPhone(String phone);

     Users info(Integer id);

     Integer updateInfo(Users users);

     List<Users> rank();

}
