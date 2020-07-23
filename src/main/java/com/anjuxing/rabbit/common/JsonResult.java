package com.anjuxing.rabbit.common;

import lombok.Data;

@Data
public class JsonResult {
    private String code;
    private Object data;
    private String msg;
}
