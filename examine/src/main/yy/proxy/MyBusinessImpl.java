package yy.proxy;

/**
 * @author XieLongZhen
 * @time 2018/2/28 10:37
 */
public class MyBusinessImpl implements MyBusiness {
    @Override
    public void xxx1(String msg) {
        System.out.println(msg);
    }
    @Override
    public void xxx2(int value) {
        System.out.println(value);
    }
}
