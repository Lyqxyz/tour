package com.tour.app.model.mapper;

import com.tour.app.model.entity.Collection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionMapper {

    Integer add(Collection collection);

    List<Collection> selectByUser(Integer uid);

    Collection has(Collection collection);

    Integer del(Integer id);
}
