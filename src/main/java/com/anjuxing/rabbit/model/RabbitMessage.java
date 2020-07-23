package com.anjuxing.rabbit.model;

import lombok.Data;

@Data
public class RabbitMessage {
    private int type;
    private String message;
}
