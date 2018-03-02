package singleton;

/**
 * 懒汉模式 - 线程不安全
 *
 * @author XieLongZhen
 * @time 2018/2/28 18:19
 */
public class LazyManSingleton {
    private static LazyManSingleton lazyManSingleton;
    private LazyManSingleton(){}
    public static LazyManSingleton getSingleton(){
        if (lazyManSingleton == null) {
            lazyManSingleton = new LazyManSingleton();
        }
        return lazyManSingleton;
    }
}
