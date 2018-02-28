package yy.proxy;

import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @author XieLongZhen
 * @time 2018/2/28 10:04
 */
public class HandlerInvocation {

    private Iterator<Interceptor> iterator;

    private Object proxy;

    private Method method;

    private Object[] args;


    public HandlerInvocation(Object proxy, Method method, Object[] args, Iterator<Interceptor> iterator) {

        this.proxy = proxy;

        this.method = method;

        this.args = args;

        this.iterator = iterator;

    }


    public Object invoke() throws Exception {

        Object result = null;

        if (iterator != null &&iterator.hasNext()) {

            Interceptor interceptor = iterator.next();

            result = interceptor.intercept(this);

        } else {

            result = method.invoke(proxy, args);

        }

        return result;

    }
}
