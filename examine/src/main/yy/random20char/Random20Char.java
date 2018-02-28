package yy.random20char;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author XieLongZhen
 * @time 2018/2/28 13:27
 */
public class Random20Char {

    static Character getRandomChar() {
        Random random = new Random();
        return (char) ('a' + random.nextInt(26));
    }

    public static void main(String[] args) {
        Set<Character> chars = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });
        while (chars.size() < 20) {
            chars.add(getRandomChar());
        }
        System.out.println(chars);
    }
}
