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

    Integer updateById(Contents contents);

    List<Contents> selectByKey(String key);

    List<Contents> all();

    Integer updataState(Contents contents);

    Integer delete(Integer cid);

    List<Contents> allByUser(Integer uid);

    List<Contents> allByUserHits(Integer uid);

    List<Contents> allById(Integer id);


}
