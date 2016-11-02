package name.guke.commons;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * <描述信息>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/11/2
 * @since <某个版本引入>
 */
public class CharsetUtils implements Serializable {

    private static final long serialVersionUID = -6419321965387545448L;

    private CharsetUtils() {}

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static final Charset UTF_16 = Charset.forName("UTF-16");

    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");

    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
}
