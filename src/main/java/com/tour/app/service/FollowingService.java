package com.tour.app.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.Following;
import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.FollowingMapper;
import com.tour.app.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingService {

    @Autowired
    FollowingMapper followingMapper;

    @Autowired
    UserMapper userMapper;

    public Object findMyFollewing(Integer uid,Integer pageSize,Integer pageNum){

        PageHelper.startPage(pageSize,pageNum);

        List<Following> myFollewing = followingMapper.findMyFollewing(uid);


        for (Following following:myFollewing){

            Users info = userMapper.info(following.getFanid());

            following.setUsers(info);

        }

        PageInfo<Following> pageInfo= new PageInfo<>(myFollewing);

        return pageInfo;

    }

    public Object findMyFans(Integer uid,Integer pageSize,Integer pageNum){

        PageHelper.startPage(pageSize,pageNum);

        List<Following> myFollewing = followingMapper.findMyFans(uid);

        for (Following following:myFollewing){

            Users info = userMapper.info(following.getUid());

            following.setUsers(info);

        }
        PageInfo<Following> pageInfo= new PageInfo<>(myFollewing);


        return pageInfo;

    }
}
