package poj;

import annotation.Accept;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 4137:最小新整数
 * <p>
 * 描述
 * 给定一个十进制正整数n(0 < n < 1000000000)，每个数位上数字均不为0。n的位数为m。
 * 现在从m位中删除k位(0<k < m)，求生成的新整数最小为多少？
 * 例如: n = 9128456, k = 2, 则生成的新整数最小为12456
 * <p>
 * 输入
 * 第一行t, 表示有t组数据；
 * 接下来t行，每一行表示一组测试数据，每组测试数据包含两个数字n, k。
 * 输出
 * t行，每行一个数字，表示从n中删除k位后得到的最小整数
 *
 * @author XieLongzhen
 * @date 2019/8/3 11:05
 */
@Accept
public class MinNewInteger {

    private static class Old {
        public String num;
        public int k;

        public Old(int num, int k) {
            this.num = String.valueOf(num);
            this.k = k;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Old> oldList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            oldList.add(new Old(scanner.nextInt(), scanner.nextInt()));
        }

        for (Old old : oldList) {
            StringBuilder newInt = new StringBuilder(old.num);
            int count = old.k;
            while (count-- > 0) {
                for (int i = 0; i < newInt.length(); i++) {
                    if (i == newInt.length() - 1 || (newInt.charAt(i) > newInt.charAt(i + 1))) {
                        newInt.deleteCharAt(i);
                        break;
                    }
                }
            }
            System.out.println(newInt.toString());
        }
    }
}
