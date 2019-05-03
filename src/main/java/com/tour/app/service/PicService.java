package com.tour.app.service;

import com.tour.app.model.entity.Pic;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.PicMapper;
import com.tour.app.untils.FileUploadUtil;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PicService {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    PicMapper picMapper;

    public ResponseInfo addpic(Pic pic, MultipartFile[] files){

        for (MultipartFile file : files) {

            try {
                String upload = fileUploadUtil.upload(file);

                pic.setPath(upload);

                picMapper.add(pic);

            } catch (IOException e) {

                ResponseInfo error = ReponseUtil.error();

                error.setMsg("文件上传失败");
                return error;
            }


        }

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("上传成功");

        return ok;

    }
}
