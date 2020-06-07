package cn.dblearn.blog.portal.common.annotation;

import java.lang.annotation.*;

/**
 * ViewLog
 *
 * @author heyou
 * @date 2019/02/15 14:51
 * @email heyou_0423@163.com
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogLike {

     String type();
}
