package com.tour.app.controller;

import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Spot;
import com.tour.app.service.SpotService;
import com.tour.app.untils.FileUploadUtil;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;

@Controller
@RequestMapping(value = "/spot")
public class SpotController {

    @Autowired
    SpotService spotService;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @ResponseBody
    @PostMapping(value = "/add")
    public Object add(Spot spot, @PathParam(value = "file")MultipartFile file) {

        try {
            String upload = fileUploadUtil.upload(file);

            spot.setSpotpic(upload);

            ResponseInfo add = spotService.add(spot);

            return add;
        } catch (IOException e) {

            ResponseInfo error = ReponseUtil.error();

            error.setMsg("图片上传失败");

            return error;
        }

    }

    @GetMapping("/addView")
    public String addView(){


        return "admin/addSpot";
    }

}
