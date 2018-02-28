package yy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XieLongZhen
 * @time 2018/2/28 10:09
 */
public class CommonProxy implements InvocationHandler {


    private static List<Interceptor> interceptorList = new ArrayList<Interceptor>();

    private Object target;


    public static void initInterceptors(List<Interceptor> list) {

        interceptorList.addAll(list);

    }


    public CommonProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HandlerInvocation handlerInvocation = new HandlerInvocation(target, method, args, interceptorList.iterator());

        return handlerInvocation.invoke();

    }


    public static void main(String[] args) {

        List<Interceptor> list = new ArrayList<Interceptor>();

        list.add(new LoggerInterceptor());

        CommonProxy.initInterceptors(list);

        MyBusinessImpl myBusinessImpl = new MyBusinessImpl();

        MyBusiness myBusiness = (MyBusiness) Proxy.newProxyInstance(MyBusiness.class.getClassLoader(),

                new Class<?>[]{MyBusiness.class}, new CommonProxy(myBusinessImpl));

        myBusiness.xxx1("aaa");

        myBusiness.xxx2(123);

    }

}