package com.tour.app.service;

import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.ContentMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
