package com.tour.app.model.mapper;

import com.tour.app.model.entity.Spot;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpotMapper {

    Integer add(Spot spot);

    Spot check(String name);
}
