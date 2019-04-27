package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Following{

    Integer id;

    Integer uid;

    Integer fanid;

    Integer state;

    Date created;

    Users users;
}
