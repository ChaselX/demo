package singleton;

/**
 * @author XieLongZhen
 * @time 2018/2/28 17:44
 */
public class StarveManSingleton {
    private static StarveManSingleton starveManSingleton = new StarveManSingleton();
    private StarveManSingleton(){}
    public static StarveManSingleton getSingleton(){
        return starveManSingleton;
    }
}
