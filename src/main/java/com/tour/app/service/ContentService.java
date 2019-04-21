package com.tour.app.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.ContentMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    ContentMapper contentMapper;

    public ResponseInfo add(Contents contents){

        Integer add = contentMapper.add(contents);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("添加成功");

        return ok;
    }


    public ResponseInfo hits(Integer id){

        Integer integer = contentMapper.updateHit(id);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("点赞成功");

        return ok;

    }

    public ResponseInfo all(){

        List<Contents> release = contentMapper.release();

        ResponseInfo ok = ReponseUtil.ok();

        ok.getInfo().put("data",release);

        return ok;
    }

    public ResponseInfo release(Integer pageSize,Integer pageNum){


        PageHelper.startPage(pageSize,pageNum);

        List<Contents> release = contentMapper.release();

        PageInfo<Contents> pageInfo= new PageInfo<>(release);


        ResponseInfo ok = ReponseUtil.ok();

        ok.getInfo().put("data",pageInfo);

        return ok;


    }

}
