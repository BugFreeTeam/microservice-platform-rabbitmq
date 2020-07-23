package com.anjuxing.rabbit.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SpaceFailMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id; //
    private String content; //
    private String exchangeName; //
    private String queueName; //
    private Integer status; // 0:未处理1：已处理
    private Date sendTime; //
    private int pageSize;
    private int pageNum;
    private String order;

    public SpaceFailMessage() {

    }

    public SpaceFailMessage(String id, String content, String exchangeName, String queueName, Integer status, Date sendTime) {
        this.id = id;
        this.content = content;
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        this.status = status;
        this.sendTime = sendTime;
    }
}
