package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Pic {

    private Integer id;

    private Integer uid;

    private Integer pid;

    private String path;

    private Integer state;

    private Date created;
}
