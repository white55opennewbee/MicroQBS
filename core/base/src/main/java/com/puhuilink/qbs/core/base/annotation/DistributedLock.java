package com.puhuilink.qbs.core.base.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DistributedLock {
    /**
     * redis 的 key
     *
     * @return
     */
    String key();

    /**
     * 锁过期时间，单位秒
     *
     * @return
     */
    int expire() default 5;

    /**
     * 休眠时间，单位毫秒
     *
     * @return
     */
    long sleep() default 100;

    /**
     * 锁的key过期时间是否可以重置
     *
     * @return
     */
    boolean reset() default true;
}
