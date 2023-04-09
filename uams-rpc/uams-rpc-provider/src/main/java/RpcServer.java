import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 */
public class RpcServer
{
    private static ClassPathXmlApplicationContext context;

    public static void main(String[] args) throws IOException
    {
        String[] config = new String[]{
                "classpath:/META-INF/spring/spring.xml",
                "classpath:/META-INF/spring/spring-jedis.xml",
                "classpath:/META-INF/spring/spring-mybatis.xml",
                "classpath:/META-INF/spring/spring-provider.xml"
        };
        context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read(); // 按任意键退出
    }
}
