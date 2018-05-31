package service.aop;

import java.lang.annotation.*;

/**
 * Created by hhs on 2018/5/31.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface jikejia {
    int value() default 1;
}
