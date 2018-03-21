package netease.rearrangementOfSeries;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author XieLongZhen
 * @time 2018/3/20 15:56
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> listList = new LinkedList<>();

        // 数组个数
        Integer len = scanner.nextInt();
        // 数组初始化
        for (int i = 0; i < len; i++) {
            Integer length = new Integer(scanner.next());
            List<Integer> integers = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                integers.add(scanner.nextInt());
            }
            listList.add(integers);
        }

        for (List<Integer> list : listList) {
            // n1: 基数 n2: 2的偶数倍 n3: 2的奇数倍
            int n1 = 0, n2 = 0, n3 = 0;
            for (Integer tmp : list) {
                if (tmp % 2 == 1) {
                    n1++;
                } else {
                    if ((tmp / 2) % 2 == 0) {
                        n2++;
                    } else {
                        n3++;
                    }
                }
            }
            if (n3 != 0) {
                if (n2 >= n1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                if (n2 > n1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
