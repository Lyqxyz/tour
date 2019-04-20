package com.tour.app.model.mapper;

import com.tour.app.model.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {

    Integer add(Tag tag);

    List<Tag> all();

    Tag check(String name);
}
