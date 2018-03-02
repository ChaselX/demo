package singleton;

/**
 * @author XieLongZhen
 * @time 2018/2/28 20:26
 */
public class DoubleLockSingleton {
    private volatile static DoubleLockSingleton doubleLockSingleton;

    private DoubleLockSingleton() {
    }

    public static DoubleLockSingleton getSingleton() {
        if (doubleLockSingleton == null) {
            synchronized (DoubleLockSingleton.class) {
                if (doubleLockSingleton == null) {
                    doubleLockSingleton = new DoubleLockSingleton();
                }
            }
        }
        return doubleLockSingleton;
    }
}
