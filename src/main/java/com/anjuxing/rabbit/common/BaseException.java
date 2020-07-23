package com.anjuxing.rabbit.common;

import com.anjuxing.rabbit.exception.UserException;
import com.anjuxing.rabbit.utils.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BaseException {

    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public JsonResult userExceptionHandler(HttpServletRequest req,UserException e){
        return ResultUtil.error(e.getCode(),e.getMessage());
    }
}
