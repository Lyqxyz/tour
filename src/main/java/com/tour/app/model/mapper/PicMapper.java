package com.tour.app.model.mapper;

import com.tour.app.model.entity.Pic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicMapper {

    List<Pic> selectPic(Integer pid);

    Integer add(Pic pic);

    Integer del(Integer id);

    List<Pic> selectLimit(Integer uid);
}
