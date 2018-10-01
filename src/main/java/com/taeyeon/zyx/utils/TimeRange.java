package com.taeyeon.zyx.utils;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/1 下午9:47
 * @Description:
 */

import java.util.Date;

public class TimeRange {

    private final Date startTime;

    private final Date endTime;

    public TimeRange(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }


    public Date getEndTime() {
        return endTime;
    }


}

