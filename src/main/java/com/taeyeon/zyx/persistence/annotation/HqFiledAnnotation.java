/**
 * Copyright (c) 2011 duowan.com. 
 * All Rights Reserved.
 * This program is the confidential and proprietary information of 
 * duowan. ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with
 * the terms of the license agreement you entered into with duowan.com.
 */
package com.taeyeon.zyx.persistence.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HqFiledAnnotation {

	/**
	 * 将各个属性分组。最常用的字段level越低。
	 * 一般就分2-4个组就够了。转换json时，可以去掉一些不常用的字段
	 * @desc
	 * @author lynn
	 * @date 下午2:04:00
	 * @return
	 * @return 
	 * @throws
	*
	 */
	int filedGrpLevel();
	
}
