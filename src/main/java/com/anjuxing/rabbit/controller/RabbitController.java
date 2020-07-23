package com.anjuxing.rabbit.controller;

import com.anjuxing.rabbit.common.BaseExceptionCode;
import com.anjuxing.rabbit.exception.UserException;
import com.anjuxing.rabbit.exception.UserExceptionCode;
import com.anjuxing.rabbit.model.RabbitMessage;
import com.anjuxing.rabbit.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private RabbitService rabbitService;


    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody RabbitMessage model){
        try {
            int i = 5 / 0;
        }catch (Exception e){
            throw new UserException(UserExceptionCode.NOT_AUTH);
        }


        return "success";
    }

}
