package netease.stringFragment;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author XieLongZhen
 * @time 2018/3/20 14:58
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length;
        Float res = new Float(0f);
        List<Integer> list = new LinkedList<>();
        if (str.length() > 0) {
            char ch = str.charAt(0);
            length = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == ch) {
                    length++;
                } else {
                    list.add(length);
                    length = 1;
                    ch = str.charAt(i);
                }
            }
            if (length != 0) {
                list.add(length);
            }

            for (Integer i : list) {
                res += i;
            }
            res /= list.size();
            System.out.println(String.format("%.2f", res));
        } else {
            System.out.println(String.format("%.2f", res));
        }
    }
}
