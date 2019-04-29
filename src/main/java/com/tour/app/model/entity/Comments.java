package com.tour.app.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 评论
 *
 * @author biezhi
 */
@Data
public class Comments {

    private Integer coid;

    private Integer cid;

    private Date created;

    // 评论作者
    private String author;

    // 评论所属用户id
    private Integer authorId;

    // 评论所属内容作者id
    private Integer ownerId;

    // 评论者邮件
    private String mail;

//    // 评论者网址
//    private String url;
//
//    // 评论者ip地址
//    private String ip;
//
//    // 评论者客户端
//    private String agent;

    // 评论内容
    private String content;

    // 评论状态
    private String state;

    private String username;

    private String logged;

    private String email;

//    // 父级评论
//    private Integer parent;

}