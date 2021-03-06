package com.tour.app.model.entity;


import lombok.Data;

import java.util.Date;

/**
 * 用户
 *
 * @author biezhi
 */
@Data
public class Users  {

    /**
     * user表主键
     */
    private Integer uid;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 用户的邮箱
     */
    private String email;

    private String phone;

    private Integer gender;

    private String age;

    private String owner;

    /**
     * 用户显示的名称
     */
    private String screenName;

    /**
     * 用户注册时的GMT unix时间戳
     */
    private Date created;

    /**
     * 最后活动时间
     */
    private Date activated;

    /**
     * 上次登录最后活跃时间
     */
    private String logged;

    /**
     * 用户组
     */
    private String state;

}