package poj;

import annotation.Accept;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 4110 圣诞老人的礼物-Santa Clau’s Gifts
 * <p>
 * 描述
 * 圣诞节来临了，在城市A中圣诞老人准备分发糖果，现在有多箱不同的糖果，
 * 每箱糖果有自己的价值和重量，每箱糖果都可以拆分成任意散装组合带走。
 * 圣诞老人的驯鹿最多只能承受一定重量的糖果，请问圣诞老人最多能带走多大价值的糖果。
 * <p>
 * 输入
 * 第一行由两个部分组成，分别为糖果箱数正整数n(1 <= n <= 100)，
 * 驯鹿能承受的最大重量正整数w（0 < w < 10000），两个数用空格隔开。
 * 其余n行每行对应一箱糖果，由两部分组成，分别为一箱糖果的价值正整数v和重量正整数w，
 * 中间用空格隔开。
 * <p>
 * 输出
 * 输出圣诞老人能带走的糖果的最大总价值，保留1位小数。输出为一行，以换行符结束。
 *
 * @author XieLongzhen
 * @date 2019/8/3 10:26
 */
@Accept
public class SantaGifts {
    private static class Gift {
        public int value;
        public int weight;
        public double x;

        public Gift(int value, int weight) {
            this.value = value;

            this.weight = weight;
            this.x = (double) value / (double) weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int w = scanner.nextInt();
        List<Gift> gifts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            gifts.add(new Gift(scanner.nextInt(), scanner.nextInt()));
        }
        gifts.sort(((o1, o2) -> {
            if (o1.x > o2.x) {
                return -1;
            } else if (o1.x == o2.x) {
                return 0;
            } else {
                return 1;
            }
        }));

        double sum = 0;
        for (Gift gift : gifts) {
            if (gift.weight <= w) {
                sum += gift.value;
            } else {
                sum += w * gift.x;
                break;
            }
            w -= gift.weight;
        }
        System.out.println(sum);
    }
}
