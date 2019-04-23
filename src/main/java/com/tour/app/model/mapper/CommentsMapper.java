package com.tour.app.model.mapper;

import com.tour.app.model.entity.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsMapper {

    Integer add(Comments comments);

    List<Comments> selectByCid(Integer cid);

    Integer updateById(Comments coid);

    List<Comments> all();

    Integer updateComments(Comments comments);

    Integer del(Integer coid);

    List<Comments> allByUser(Integer uid);

}
