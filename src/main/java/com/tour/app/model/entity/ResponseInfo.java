package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseInfo {

    private String code;

    private String msg;

    private Date data=new Date();

    private Map<String ,Object> info= new HashMap<String,Object>();
}
