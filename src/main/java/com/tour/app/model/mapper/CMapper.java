package com.tour.app.model.mapper;

import com.tour.app.model.entity.C;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CMapper {

    Integer add(C c);

    List<C> all();

    C check(String name);

}
