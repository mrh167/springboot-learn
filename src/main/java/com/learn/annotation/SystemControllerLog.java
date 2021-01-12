package com.learn.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented//表明这个注解应该被javadoc工具记录
public @interface SystemControllerLog {
    //描述方法，
    String description() default "";
}
