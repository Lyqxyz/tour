package com.tour.app.model.mapper;

import com.tour.app.model.entity.Contents;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    Integer add(Contents contents);

    List<Contents> release();

    Integer updateHit(Integer cid);

    Contents selectById(Integer id);

    Integer updateById(String id);

}
