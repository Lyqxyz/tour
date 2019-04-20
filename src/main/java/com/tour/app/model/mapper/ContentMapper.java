package com.tour.app.model.mapper;

import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.Contents;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentMapper {

    Integer add(Contents contents);
}
