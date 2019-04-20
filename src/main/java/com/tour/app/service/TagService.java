package com.tour.app.service;

import com.tour.app.model.entity.C;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Tag;
import com.tour.app.model.mapper.TagMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TagService {

    @Autowired
    TagMapper tagMapper;

    public ResponseInfo add(Tag tag){

        Tag check = tagMapper.check(tag.getName());

        if(Objects.isNull(check)){

            Integer add = tagMapper.add(tag);

            ResponseInfo ok = ReponseUtil.ok();

            ok.setMsg("添加成功");
            return ok;
        }else{

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("标签名已经存在");

            return error;
        }


    }


    public ResponseInfo all(){

        List<Tag> all = tagMapper.all();

        ResponseInfo ok = ReponseUtil.ok();

        ok.getInfo().put("data",all);

        return ok;

    }
}
