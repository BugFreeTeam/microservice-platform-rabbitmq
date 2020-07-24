package com.anjuxing.rabbit.common;

import com.anjuxing.rabbit.exception.UserException;
import com.anjuxing.rabbit.utils.ResultUtil;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义用户异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public JsonResult userExceptionHandler(HttpServletRequest req,UserException e){
        return ResultUtil.error(e.getCode(),e.getMessage());
    }

    /**
     *  http请求的方法不正确
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public JsonResult httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        JsonResult jsonResult=new JsonResult();
        jsonResult.setCode("401");
        jsonResult.setMsg("http请求方法不正确!");
        return jsonResult;
    }


    /**
     *  其他异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult error(Exception e){
        JsonResult jsonResult=new JsonResult();
        jsonResult.setCode("500");
        jsonResult.setMsg("服务器内部错误!"+e.getMessage());
        return jsonResult;
    }

}
