package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PicClass {

    private Integer id;

    private Integer uid;

    private String name;

    private Integer state;

    private Date created;
}
