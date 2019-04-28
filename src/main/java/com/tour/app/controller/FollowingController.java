package com.tour.app.controller;

import com.tour.app.model.entity.Following;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.FollowingMapper;
import com.tour.app.service.FollowingService;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/fan")
public class FollowingController {

    @Autowired
    FollowingMapper followingMapper;

    @Autowired
    FollowingService followingService;

    @ResponseBody
    @GetMapping("/follow/{id}/{pageSize}/{pageNum}")
    public Object following(@PathVariable("id")Integer id,
                            @PathVariable("pageSize")Integer pageSize,
                            @PathVariable("pageNum")Integer pageNum){

        Object myFollewing = followingService.findMyFollewing(id, pageSize, pageNum);

        return myFollewing;
    }

    @ResponseBody
    @GetMapping("/followed/{id}/{pageSize}/{pageNum}")
    public Object followed(@PathVariable("id")Integer id,
                            @PathVariable("pageSize")Integer pageSize,
                            @PathVariable("pageNum")Integer pageNum){

        Object myFollewing = followingService.findMyFans(id, pageSize, pageNum);

        return myFollewing;
    }

    @ResponseBody
    @GetMapping("/del/{id}")
    public Object del(@PathVariable("id")Integer id){

        Integer del = followingMapper.del(id);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("取消成功");

        return ok;

    }

    @ResponseBody
    @PostMapping("/add")
    public Object add(Following following){

        Following following1 = followingMapper.find(following);

        if(Objects.isNull(following1)){

            Integer add = followingMapper.add(following);

            ResponseInfo ok = ReponseUtil.ok();

            ok.setMsg("你以成功关注");

            return ok;
        }else{

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("你已经关注过了");

            return error;
        }
    }

    @GetMapping("/fanView")
    public String fan(){

        return "admin/followingTable";
    }

    @GetMapping("/fanedView")
    public String faned(){

        return "admin/followedTable";
    }
}
