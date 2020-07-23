package com.anjuxing.rabbit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * SimpleDateFormat日期+时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * SimpleDateFormat日期格式yyyy-MM-dd
     */
    public static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getCurentDate() throws Exception{
        Date date=new Date();
        try {
            return SDF_DATETIME.parse(SDF_DATETIME.format(date));
        } catch (ParseException e) {
            throw new Exception("时间转换异常");
        }
    }
}
