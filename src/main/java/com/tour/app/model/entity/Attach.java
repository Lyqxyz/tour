package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 附件
 * <p>
 * Created by biezhi on 2017/2/23.
 */
@Data

public class Attach {

    private Integer id;

    private String  fname;

    private String  ftype;

    private String  fkey;

    private Integer authorId;

    private Date created;

}
