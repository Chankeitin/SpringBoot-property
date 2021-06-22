package com.bnuz.util;

/**
 * @author Chanchitin
 * @date 2021/5/30
 */

import java.lang.annotation.*;

/**
 * Security允许匿名访问
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnonymousAccess {
}