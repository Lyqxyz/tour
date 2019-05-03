package com.tour.app.model.mapper;

import com.tour.app.model.entity.PicClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicClassMapper {

    Integer add(PicClass picClass);

    List<PicClass> allByUser(Integer id);

    Integer update(PicClass picClass);

}
