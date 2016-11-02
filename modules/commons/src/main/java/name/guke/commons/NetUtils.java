package name.guke.commons;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * 网络工具包
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/11/2
 * @since 1.0
 */
public class NetUtils implements Serializable {
    private static final long serialVersionUID = 2123670526741681276L;

    public static final String LOCALHOST = "127.0.0.1";

    public static final String ANYHOST = "0.0.0.0";

    private static final int MIN_PORT = 0;

    private static final int MAX_PORT = 65535;

    private static final int RND_PORT_START = 30000;

    private static final int RND_PORT_RANGE = 10000;
    /**
     * IP4
     */
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^\\d{1,3}(\\.\\d{1,3}){3}\\:\\d{1,5}$");

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static boolean isInvalidPort(int port){
        return port > MIN_PORT && port <= MAX_PORT;
    }

    public static int getRandomPort() {
        return getRandomPort(RND_PORT_START, RND_PORT_RANGE);
    }

    public static int getRandomPort(int portStart) {
        return getRandomPort(portStart, RND_PORT_RANGE);
    }

    public static int getRandomPort(int portStart, int portRange) {
        return portStart + RANDOM.nextInt(portRange);
    }

    public static int getAvailablePort() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket();
            ss.bind(null);
            return ss.getLocalPort();
        } catch (IOException e) {
            return getRandomPort();
        } finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                }
            }
        }
    }


    public static int getAvailablePort(String host, int port) {
        if (port <= 0) {
            return getAvailablePort();
        }
        for(int i = port; i < 65535; i ++) {
            ServerSocket ss = null;
            try {
                ss = new ServerSocket();
                ss.bind(new InetSocketAddress(host, i));
                return i;
            } catch (IOException e) {
                // continue
            } finally {
                if (ss != null) {
                    try {
                        ss.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        throw new RuntimeException("无法绑定服务到该指定的IP" + host + "的任何端口，请检查配置");
    }

}
