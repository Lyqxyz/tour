package com.tour.app.model.mapper;

import com.tour.app.model.entity.Following;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowingMapper {

    Integer add(Following following);

    Following find(Following following);

    List<Following> findMyFollewing(Integer id);

    List<Following> findMyFans(Integer id);

    Integer del(Integer id);

    Following has(Following following);

}
