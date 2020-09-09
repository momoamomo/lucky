package com.szl.lucky.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunzhilin
 * @date 2020/9/9  16:30
 */
/**
 * @Type:NotNull
 * @Desc: 不为空校验 实体类接收的时候实体类里面的字段也要加此注解，且接收的实体类不能继承别的类
 * @Author:jiangyunxing
 * @date:2019/11/20 10:11
 * @version
 */
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    boolean stringNotBlank() default true;
}
