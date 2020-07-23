package com.anjuxing.rabbit.utils;

import com.anjuxing.rabbit.common.JsonResult;

public class ResultUtil {

    /**返回成功 */
    public static JsonResult success(){
        JsonResult result = new JsonResult();
        result.setCode("0");//成功
        result.setMsg("成功");//提示语
        return result;
    }

    /**返回成功 */
    public static JsonResult success(Object object){
        JsonResult result = new JsonResult();
        result.setCode("0");//成功
        result.setMsg("成功");//提示语
        result.setData(object);//返回内容
        return result;
    }

    /**返回失败 */
    public static JsonResult error(){
        JsonResult result = new JsonResult();
        result.setCode("1");//失败
        result.setMsg("失败");//提示语
        return result;
    }

    /**返回失败 */
    public static JsonResult error(String code, String msg){
        JsonResult result = new JsonResult();
        result.setCode(code);//失败
        result.setMsg(msg);//提示语
        return result;
    }

}
