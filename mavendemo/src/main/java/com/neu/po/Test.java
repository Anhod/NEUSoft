package com.neu.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) throws ParseException {
        // 日期转毫秒
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        long time = format.parse("1970-1-1").getTime();
        System.out.println(time);

        // 毫秒转日期对象
        Date date = new Date();
        date.setTime(-28800000);
        System.out.println(date);

        Date re = format.parse("2020-5-12");
        System.out.println(re);
    }
}
