package com.taeyeon.zyx.exception;

/**
 * @author zyx
 * @date 2018/9/27 027 10:50
 */

import org.apache.commons.lang3.StringUtils;

public class UdbIllegalArgumentException extends RuntimeException {
    private String message;
    private static final long serialVersionUID = 1L;

    public UdbIllegalArgumentException(String message) {
        super(message);
    }

    public UdbIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return StringUtils.isEmpty(this.message) ? super.getMessage() : this.message;
    }
}

