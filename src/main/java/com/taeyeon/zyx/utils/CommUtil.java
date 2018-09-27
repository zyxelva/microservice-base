package com.taeyeon.zyx.utils;

/**
 * @author zyx
 * @date 2018/9/27 027 10:37
 */
public class CommUtil {
    public CommUtil() {
    }

    public static boolean equal(Long l1, Long l2) {
        if (null == l1) {
            return null == l2;
        } else {
            return null != l2 && l1.equals(l2);
        }
    }

    public static boolean isValid(Long l) {
        return null != l && l > 0L;
    }
}
