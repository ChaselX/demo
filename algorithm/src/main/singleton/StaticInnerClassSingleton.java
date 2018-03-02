package singleton;

/**
 * @author XieLongZhen
 * @time 2018/2/28 21:19
 */
public class StaticInnerClassSingleton {

    private static class SingletonHolder{
        private static final StaticInnerClassSingleton SINGLETON = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getSingletion(){
        return SingletonHolder.SINGLETON;
    }
}
