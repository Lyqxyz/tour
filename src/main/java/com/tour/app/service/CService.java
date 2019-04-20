package com.tour.app.service;

import com.tour.app.model.entity.C;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.CMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CService {

    @Autowired
    CMapper cMapper;


    public ResponseInfo add(C c){

        C check = cMapper.check(c.getName());

        if(Objects.isNull(check)){

            Integer add = cMapper.add(c);

            ResponseInfo ok = ReponseUtil.ok();

            ok.setMsg("添加成功");
            return ok;
        }else{

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("类名已经存在");

            return error;
        }


    }


    public ResponseInfo all(){

        List<C> all = cMapper.all();

        ResponseInfo ok = ReponseUtil.ok();

        ok.getInfo().put("data",all);


        return ok;

    }
}
