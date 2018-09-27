package com.taeyeon.zyx.session;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author zyx
 * @date 2018/9/27 027 11:52
 */
public class Session {
    public static final String SESSIONUID = "sessionUid";
    private static final ThreadLocal<String> sessionUid = new TransmittableThreadLocal();

    public Session() {
    }

    public static String getSessionUid() {
        return (String) sessionUid.get();
    }

    public static Long getIntSessionUid() {
        return sessionUid.get() == null ? null : Long.valueOf((String) sessionUid.get());
    }

    public static void addSessionUid(String uid) {
        sessionUid.set(uid);
    }

    public static void removeSessionUid() {
        sessionUid.remove();
    }
}
