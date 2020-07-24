package com.anjuxing.rabbit.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotFoundException implements ErrorController {

    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = {"/error"})
    @ResponseBody
    public JsonResult error(HttpServletRequest request) {
        JsonResult jsonResult=new JsonResult();
        jsonResult.setCode("404");
        jsonResult.setMsg("找不到访问资源!");
        return jsonResult;
    }

}
