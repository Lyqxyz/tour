package com.tour.app.model.entity;


import lombok.Data;

import java.util.Date;

/**
 * 文章
 *
 * @author biezhi
 */
@Data

public class Contents  {

    /**
     * 文章表主键
     */
    private Integer cid;

    /**
     * 心得标题
     */
    private String title;

    /**
     * 文章缩略名
     */
    private String slug;

    /**
     * 文章创建时间戳
     */
    private Date created;

    /**
     * 文章修改时间戳
     */
    private Date modified;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章创建用户
     */
    private Integer authorId;

    /**
     * 文章点击次数
     */
    private Integer hits;

    /**
     * 文章类型： PAGE、POST
     */
    private String type;
    /**
     * 文章缩略图
     */
    private String thumbImg;
    /**
     * 标签列表
     */
    private String tags;

//    /**
//     * 分类列表
//     */
//    private String categories;


    private String state;

    /**
     * 内容所属评论数
     */
    private Integer commentsNum;

    /**
     * 是否允许评论
     */
    private Integer allowComment;



}