package name.guke.commons.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * <描述信息>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/11/2
 * @since <某个版本引入>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD, LOCAL_VARIABLE, METHOD, PARAMETER})
public @interface ExcelField {
    String displayName();

    String dec();

    Class<?> type() default java.lang.String.class;

    Align align() default Align.AUTO;

    int sort() default 1;


}
