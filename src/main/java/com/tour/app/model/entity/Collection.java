package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Collection {

    private Integer id;
    private Integer uid;
    private Integer cid;
    private Integer oid;

    private Date created;

    private String title;

}
