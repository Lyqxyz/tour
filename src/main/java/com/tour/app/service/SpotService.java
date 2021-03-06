package com.tour.app.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Spot;
import com.tour.app.model.mapper.SpotMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SpotService {

    @Autowired
    SpotMapper spotMapper;

    public ResponseInfo add(Spot spot){

        Spot check = spotMapper.check(spot.getSpotname());
        if(Objects.isNull(check)){
            spotMapper.add(spot);
            ResponseInfo ok = ReponseUtil.ok();
            ok.setMsg("添加成功");
            return ok;

        }else{
            ResponseInfo error = ReponseUtil.error();
            error.setMsg("景点已经存在了");
            return error;
        }

    }


    public ResponseInfo all(Integer pageSize,Integer pageNum){

        PageHelper.startPage(pageSize,pageNum);

        List<Spot> all = spotMapper.all();

        PageInfo<Spot> pageInfo=new PageInfo<>(all);

        ResponseInfo ok = ReponseUtil.ok();

        ok.getInfo().put("data",pageInfo);

        return ok;

    }
}
