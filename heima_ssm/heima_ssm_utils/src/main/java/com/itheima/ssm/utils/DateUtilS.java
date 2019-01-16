package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 19:48
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public class DateUtilS {
    public static String dateToString(Date date, String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format=sdf.format(date);
        return format;
    }


    public static Date stringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        Date date=sdf.parse(str);
        return date;
    }
}
