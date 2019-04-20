package com.tour.app.service;

import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.CommentsMapper;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    CommentsMapper commentsMapper;

    public ResponseInfo add(Comments comments){

        Integer add = commentsMapper.add(comments);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("添加成功");

        return ok;

    }


}
