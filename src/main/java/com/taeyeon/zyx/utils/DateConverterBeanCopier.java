package com.taeyeon.zyx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 针对BeanCopier的日期转换类
 * Created by linyoulong on 2017/9/15.
 */
public class DateConverterBeanCopier implements net.sf.cglib.core.Converter{
    public Object convert(Object arg1, Class arg0, Object context){
        if (arg1 instanceof String && arg0 != String.class) {
            String p = (String) arg1;
            if (p == null || p.trim().length() == 0) {
                return null;
            }
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.parse(p.trim());
            } catch (Exception e) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(p.trim());
                } catch (ParseException ex) {
                    return arg1;
                }
            }
        }/** 输入String ,输出String */
        else if (arg1 instanceof String && arg0 == String.class) {
            return arg1;
        }/** 输入Date ,输出String */
        else if (arg1 instanceof java.util.Date) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.format((java.util.Date) arg1);
            } catch (Exception e) {
                return null;
            }
        }/** 输入Date ,输出String */
        else if (arg1 instanceof java.sql.Date) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.format((java.sql.Date) arg1);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
