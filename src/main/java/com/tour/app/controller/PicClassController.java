package com.tour.app.controller;

import com.tour.app.model.entity.PicClass;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.PicClassMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/pc")
public class PicClassController {

    @Autowired
    PicClassMapper picClassMapper;

    @ResponseBody
    @GetMapping("/info/{id}")
    public Object selectByUid(@PathVariable("id")Integer uid){

        List<PicClass> picClasses = picClassMapper.allByUser(uid);

        return picClasses;

    }


    @ResponseBody
    @PostMapping("/addInfo")
    public Object addinfo(PicClass picClass){

        picClassMapper.add(picClass);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("添加成功");
        return ok;

    }

    @ResponseBody
    @PostMapping("/update")
    public Object update(PicClass picClass){

        picClassMapper.update(picClass);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("修改成功");
        return ok;

    }

    @ResponseBody
    @GetMapping("/del/{id}")
    public Object del(@PathVariable("id")Integer id){

        Integer del = picClassMapper.del(id);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("删除成功");

        return ok;
    }

    @GetMapping("/add")
    public String add(){

        return "pic/addPicClass";
    }
}
