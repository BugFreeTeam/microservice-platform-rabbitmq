package com.anjuxing.rabbit.service.impl;


import com.alibaba.fastjson.JSON;
import com.anjuxing.rabbit.config.RabbitConfig;
import com.anjuxing.rabbit.mapper.SpaceFailMessageMapper;
import com.anjuxing.rabbit.model.RabbitMessage;
import com.anjuxing.rabbit.model.SpaceFailMessage;
import com.anjuxing.rabbit.model.SpaceUser;
import com.anjuxing.rabbit.service.RabbitService;
import com.anjuxing.rabbit.utils.DateUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service("rabbitService")
public class RabbitServiceImpl implements RabbitService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private SpaceFailMessageMapper spaceFailMessageMapper;

    final RabbitTemplate.ConfirmCallback confirmCallback=new RabbitTemplate.ConfirmCallback() {

        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if(ack){
                SpaceFailMessage message=new SpaceFailMessage();
                message.setId(correlationData.getId());
                message.setStatus(1);
                spaceFailMessageMapper.update(message);
            }else{
                SpaceFailMessage fail=spaceFailMessageMapper.selectById(correlationData.getId());
                fail.setStatus(2);
                spaceFailMessageMapper.update(fail);
            }
        }
    };

    final RabbitTemplate.ReturnCallback returnCallback=new RabbitTemplate.ReturnCallback() {

        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            System.out.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };

    public void sendUser(String message) throws Exception {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id + 时间戳 全局唯一
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        SpaceFailMessage faileMsg=new SpaceFailMessage(correlationData.getId(), message, RabbitConfig.DESTINATION_DERECT_NAME, "user", 0, DateUtils.getCurentDate());
        spaceFailMessageMapper.save(faileMsg);
        rabbitTemplate.convertAndSend(RabbitConfig.DESTINATION_DERECT_NAME,RabbitConfig.KEY_USER_NAME,message,correlationData);
    }


    public void sendMessage(RabbitMessage model) throws Exception {
        int type=model.getType();
        switch (type){
            case 1:
                sendUser(model.getMessage());
                default:
                    System.out.println("无此类型");
        }
    }

}
