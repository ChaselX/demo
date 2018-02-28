package yy.proxy;

/**
 * @author XieLongZhen
 * @time 2018/2/28 10:36
 */
public class LoggerInterceptor implements Interceptor {

    @Override
    public Object intercept(HandlerInvocation invocation) throws Exception {

        System.out.println("pre handle");

        Object result = invocation.invoke();

        System.out.println("post handle");

        return result;

    }

}