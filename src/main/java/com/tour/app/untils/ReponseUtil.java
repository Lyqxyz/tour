package com.tour.app.untils;

import com.tour.app.model.entity.ResponseInfo;

public class ReponseUtil {

    public final static ResponseInfo ok(){


        ResponseInfo responseInfo = new ResponseInfo();


        responseInfo.setCode("1");

        responseInfo.setMsg("请求成功");
        return responseInfo;

    }

    public final static ResponseInfo error(){


        ResponseInfo responseInfo = new ResponseInfo();

        responseInfo.setCode("-1");

        responseInfo.setMsg("请求失败");
        return responseInfo;

    }
}
