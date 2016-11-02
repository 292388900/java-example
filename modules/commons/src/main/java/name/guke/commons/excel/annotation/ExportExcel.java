package name.guke.commons.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * <描述信息>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/11/2
 * @since <某个版本引入>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE})
public @interface ExportExcel {

    Version version() default Version.VER_2007;

    String fileName();

    String dec();

}