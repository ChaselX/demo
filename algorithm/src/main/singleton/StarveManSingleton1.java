package singleton;

/**
 * @author XieLongZhen
 * @time 2018/2/28 18:26
 */
public class StarveManSingleton1 {
    private static StarveManSingleton1 starveManSingleton1;
    private StarveManSingleton1(){}
    public static synchronized StarveManSingleton1 getSingleton(){
        if (starveManSingleton1 == null) {
            starveManSingleton1 = new StarveManSingleton1();
        }
        return starveManSingleton1;
    }
}
