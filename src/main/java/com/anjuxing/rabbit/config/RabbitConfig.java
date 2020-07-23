package com.anjuxing.rabbit.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    /**
     * 交换机
     */
    public static final String DESTINATION_DERECT_NAME = "rabbitMq_direct";

    public static final String DESTINATION_FANOUT_NAME = "rabbitMq_fanout";

    public static final String DESTINATION_TOPIC_NAME = "rabbitMq_topic";

    /**
     * 队列
     * @return
     */
    public static final String QUEUE_USER_NAME = "queue_user";

    public static final String QUEUE_SMS_NAME = "queue_sms";

    public static final String QUEUE_EMAIL_NAME = "queue_email";

    public static final String QUEUE_TOPICA_NAME = "queue_topica";

    public static final String QUEUE_TOPICB_NAME = "queue_topicb";

    public static final String QUEUE_TOPICC_NAME = "queue_topicc";

    /**
     * routing_key
     * @return
     */
    public static final String KEY_USER_NAME = "key_user";



    //配置derect交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DESTINATION_DERECT_NAME);
    }

    //配置fanout交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(DESTINATION_FANOUT_NAME);
    }

    //配置topic交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(DESTINATION_TOPIC_NAME);
    }

    //配置队列
    @Bean
    public Queue spaceUserQueue(){
        return new Queue(QUEUE_USER_NAME,true);
    }

    @Bean
    public Queue smsQueue(){
        return new Queue(QUEUE_SMS_NAME,true);
    }

    @Bean
    public Queue emailQueue(){
        return new Queue(QUEUE_EMAIL_NAME,true);
    }

    @Bean
    public Queue topicaQueue(){
        return new Queue(QUEUE_TOPICA_NAME);
    }

    @Bean
    public Queue topicbQueue(){
        return new Queue(QUEUE_TOPICB_NAME);
    }

    @Bean
    public Queue topiccQueue(){
        return new Queue(QUEUE_TOPICC_NAME);
    }

    //队列绑定direct
    @Bean
    public Binding userBidingDirect(){
        return BindingBuilder.bind(spaceUserQueue()).to(directExchange()).with(KEY_USER_NAME);
    }

    //队列绑定fanout交换机
    @Bean
    public Binding smsBindingFanout(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding emailBindingFanout(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }

    //队列绑定topic交换机

    @Bean
    public Binding topicaBindingTopic(){
        return BindingBuilder.bind(topicaQueue()).to(topicExchange()).with("#.a");
    }

    @Bean
    public Binding topicbBindingTopic(){
        return BindingBuilder.bind(topicbQueue()).to(topicExchange()).with("key_topic.*");
    }

    @Bean
    public Binding topiccBindingTopic(){
        return BindingBuilder.bind(topiccQueue()).to(topicExchange()).with("#.*");
    }




}
