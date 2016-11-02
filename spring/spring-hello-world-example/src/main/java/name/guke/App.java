package name.guke;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <描述信息>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/10/11
 * @since <某个版本引入>
 */
public class App {
    public static void main(String[] args) {
        //根据路径加载配置
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //根据bean-id获取bean，唯一
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
        //通过类型获取bean，可能存在多个同类型的bean，直接调用方法可能导致失败
        context.getBean(HelloWorld.class).printHello();
    }
}
