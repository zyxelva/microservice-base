package com.taeyeon.zyx.exception;

/**
 * @author zyx
 * @date 2018/9/27 027 10:52
 */
public class InvalidDateTimeFormatException extends UdbIllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public InvalidDateTimeFormatException(String datetime) {
        super("非法时间格式[" + datetime + "].");
    }
}
