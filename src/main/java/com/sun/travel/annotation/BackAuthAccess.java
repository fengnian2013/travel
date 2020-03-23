package com.sun.travel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 后台账号验证
 *
 * @ProjectName code
 * @Author zhangkaiting
 * @CreateTime 2019-04-03 16:43
 * @Description
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BackAuthAccess {

}