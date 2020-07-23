package com.anjuxing.rabbit.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SpaceUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id; //
    private String userName; // 用户名
    private String password; // 密码
    private Integer sex; // 性别
    private String address; // 地址
    private String phone; // 电话
    private Date createTime; // 创建时间
    private String createBy; // 创建人


}
