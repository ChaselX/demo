package netease.oppositeNumber;

import java.util.Scanner;

/**
 * @author XieLongZhen
 * @time 2018/3/20 14:31
 */
public class Main {

    static Integer getOppositeNumber(Integer n) {
        StringBuilder builder = new StringBuilder(n.toString());
        builder.reverse();
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == 0){
                builder.deleteCharAt(i--);
            }
        }
        if (builder.charAt(builder.length()-1) == '-') {
            builder.deleteCharAt(builder.length() - 1);
            builder.insert(0, '-');
        }
        Integer tmp = new Integer(builder.toString());
        tmp += n;
        return tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        System.out.println(getOppositeNumber(n));
    }
}
