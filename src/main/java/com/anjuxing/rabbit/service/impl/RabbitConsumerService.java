package com.anjuxing.rabbit.service.impl;

import com.anjuxing.rabbit.config.RabbitConfig;
import com.anjuxing.rabbit.mapper.SpaceUserMapper;
import com.anjuxing.rabbit.model.SpaceUser;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@Component
public class RabbitConsumerService {

    @Resource
    private SpaceUserMapper spaceUserMapper;


    @RabbitListener(queues= RabbitConfig.QUEUE_USER_NAME)
    public void a_consumer(SpaceUser model, Message message, Channel channel) throws IOException{
        try{
            spaceUserMapper.save(model);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            System.out.println("消费失败");
            throw new RuntimeException("业务出错");
        }

    }

    @RabbitListener(queues=RabbitConfig.QUEUE_SMS_NAME)
    public void b_consumer(SpaceUser model){
        model.setId(UUID.randomUUID().toString());
        System.out.println("消费b。。。。。。。。。。。。。。。");
        //spaceUserMapper.save(model);
    }

    @RabbitListener(queues=RabbitConfig.QUEUE_EMAIL_NAME)
    public void c_consumer(SpaceUser model){
        model.setId(UUID.randomUUID().toString());
        System.out.println("消费c。。。。。。。。。。。。。。。");
        //spaceUserMapper.save(model);
    }

    @RabbitListener(queues=RabbitConfig.QUEUE_TOPICA_NAME)
    public void t_a_consumer(SpaceUser model){
        model.setId(UUID.randomUUID().toString());
        System.out.println("消费t_a。。。。。。。。。。。。。。。");
        //spaceUserMapper.save(model);
    }

    @RabbitListener(queues=RabbitConfig.QUEUE_TOPICB_NAME)
    public void t_b_consumer(SpaceUser model){
        model.setId(UUID.randomUUID().toString());
        System.out.println("消费t_b。。。。。。。。。。。。。。。");
        //spaceUserMapper.save(model);
    }

    @RabbitListener(queues=RabbitConfig.QUEUE_TOPICC_NAME)
    public void t_c_consumer(SpaceUser model){
        model.setId(UUID.randomUUID().toString());
        System.out.println("消费t_c。。。。。。。。。。。。。。。");
        //spaceUserMapper.save(model);
    }

}
