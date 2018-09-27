package com.taeyeon.zyx.dto;

/**
 * @author zyx
 * @date 2018/9/26 026 18:22
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DtoProperty {
    String value() default "";

    boolean hidden() default false;

    boolean required() default false;

    DtoProperty.AccessMode accessMode() default DtoProperty.AccessMode.AUTO;

    public static enum AccessMode {
        AUTO,
        READ_ONLY,
        READ_WRITE;

        private AccessMode() {
        }
    }
}

