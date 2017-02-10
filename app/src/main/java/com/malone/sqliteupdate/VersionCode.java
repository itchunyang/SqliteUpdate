package com.malone.sqliteupdate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by luchunyang on 2017/2/10.
 * 该注解的作用是定义Upgrade子类的数据库版本号，在子类使用.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface VersionCode {
    int value() default 1;
}
