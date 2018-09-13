package com.myuserid.auth;

import java.lang.annotation.*;

/**
 * 认证注解
 * Created by Administrator on 2018/8/1.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {

    String[] value() default {};

    String[] authorities() default {};

    String[] roles() default {};

}
