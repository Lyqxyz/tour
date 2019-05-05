package com.tour.app.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.Collection;
import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.CollectionMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CollectionMapper collectionMapper;

    @ResponseBody
    @PostMapping("/add")
    public Object add(Collection collection){

        Collection has = collectionMapper.has(collection);

        if(Objects.isNull(has)){

            Integer add = collectionMapper.add(collection);

            ResponseInfo ok = ReponseUtil.ok();

            ok.setMsg("收藏成功");
            return ok;

        }else{

            ResponseInfo error = ReponseUtil.error();
            error.setMsg("已经收藏过了");
            return  error;
        }

    }

    @ResponseBody
    @GetMapping(path = "/info/{uid}/{pageSize}/{pageNum}")
    public Object info(@PathVariable("uid")Integer id,
                       @PathVariable(value = "pageSize")Integer pageSize,
                       @PathVariable(value = "pageNum")Integer pageNum){

        PageHelper.startPage(pageSize,pageNum);

        List<Collection> collections = collectionMapper.selectByUser(id);

        PageInfo<Collection> pageInfo= new PageInfo<>(collections);

        return pageInfo;
    }

    @GetMapping("/del/{id}")
    @ResponseBody
    public Object del(@PathVariable("id")Integer id){
        Integer del = collectionMapper.del(id);

        ResponseInfo ok = ReponseUtil.ok();
        ok.setMsg("删除成功");

        return ok;

    }

    @GetMapping("/MyColl")
    public String myView(){

        return "admin/collectionTable";
    }

}
