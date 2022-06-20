package com.lgk.producerb.aop.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAopAnnotation {
    /**
     *
     * @return 指定值
     */
    String value() default "";

    /**
     *
     * @return 指定名称
     */
    String name() default "";

}
