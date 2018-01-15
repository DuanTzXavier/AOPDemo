package com.tzduan.remix.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tzduan on 17/11/15.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD })
public @interface Trace {}