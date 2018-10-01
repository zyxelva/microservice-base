package com.taeyeon.zyx.dto;

import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/1 下午8:01
 * @Description:
 */

public class NoNullStyle extends ToStringStyle implements Serializable {

    private static final long serialVersionUID = 2347542971151578670L;

    @Override
    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        if (value != null) {
            super.append(buffer, fieldName, value, fullDetail);
        }
    }
}

