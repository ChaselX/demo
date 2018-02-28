package yy.proxy;

/**
 * @author XieLongZhen
 * @time 2018/2/28 10:07
 */
public interface Interceptor {
    Object intercept(HandlerInvocation invocation) throws Exception;
}
