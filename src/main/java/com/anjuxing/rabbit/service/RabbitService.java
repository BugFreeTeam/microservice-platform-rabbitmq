package com.anjuxing.rabbit.service;


import com.anjuxing.rabbit.model.RabbitMessage;

public interface RabbitService {
    public void sendMessage(RabbitMessage model) throws Exception;
}
