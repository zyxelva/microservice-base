package com.taeyeon.zyx.persistence.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DataSourceSetter {
	String source() default "";
}
