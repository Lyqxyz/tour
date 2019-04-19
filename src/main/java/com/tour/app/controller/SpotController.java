package com.tour.app.controller;

import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Spot;
import com.tour.app.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spot")
public class SpotController {

    @Autowired
    SpotService spotService;

    @ResponseBody
    @PostMapping(value = "/add")
    public Object add(Spot spot){

        ResponseInfo add = spotService.add(spot);

        return add;
    }

    @GetMapping("/addView")
    public String addView(){


        return "admin/addSpot";
    }

}
