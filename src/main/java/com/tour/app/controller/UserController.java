package com.tour.app.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.net.httpserver.HttpsConfigurator;
import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.UserMapper;
import com.tour.app.service.UserService;
import com.tour.app.untils.FileUploadUtil;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    @ResponseBody
    public Object login(Users users, HttpSession session){

        ResponseInfo login = userService.login(users,session);

        return login;
    }

    @PostMapping("/reg")
    @ResponseBody
    public Object reg(Users users){

        ResponseInfo reg = userService.reg(users);

        return reg;
    }

    @ResponseBody
    @PostMapping("/user/pwd/{id}")
    public Object updatePwd(Users users ,@PathVariable("id")Integer uid){

        users.setUid(uid);

        ResponseInfo responseInfo = userService.updatePwd(users);

        return responseInfo;

    }


    @ResponseBody
    @PostMapping("/user/pic/{id}")
    public Object updatePic(@PathVariable("id")Integer uid, @PathParam("file")MultipartFile file){


        try {
            String upload = fileUploadUtil.upload(file);

            Users users =new Users();

            users.setUid(uid);

            users.setLogged(upload);

            userMapper.updatePic(users);

            ResponseInfo ok = ReponseUtil.ok();

            ok.getInfo().put("path",upload);

            ok.setMsg("上传成功");

            return ok;
        } catch (IOException e) {


            ResponseInfo error = ReponseUtil.error();
            error.setMsg("文件上传失败");

            return error;
        }
    }


    @ResponseBody
    @GetMapping("/user/{pageSize}/{pageNum}")
    public Object allByUser(@PathVariable(value = "pageSize")Integer pageSize,
                            @PathVariable(value = "pageNum")Integer pageNum){


        PageHelper.startPage(pageSize,pageNum);

        List<Users> all = userMapper.all();

        PageInfo<Users> pageInfo= new PageInfo<>(all);

        return pageInfo;

    }

    @ResponseBody
    @GetMapping("/admin/{id}")
    public Object toAdmin(@PathVariable(value = "id")Integer id){


        Integer integer = userMapper.toAdmin(id);
        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("设置成功");

        return ok;

    }

    @ResponseBody
    @GetMapping("/user/del/{id}")
    public Object del(@PathVariable(value = "id")Integer id){


        Integer integer = userMapper.del(id);
        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("删除成功");

        return ok;

    }

    @GetMapping("/users")
    public String users(){

        return "admin/UserTables";
    }


    @GetMapping("/loginView")
    public String loginView(){

        return "admin/login";
    }

    @GetMapping("/regView")
    public String regView(){

        return "admin/register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.removeAttribute("user");

       return "redirect:/loginView";

    }

    @GetMapping("/user/info")
    public String userInfo(){


        return "admin/updatePwd";
    }

}
