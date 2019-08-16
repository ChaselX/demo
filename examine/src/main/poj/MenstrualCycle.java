package poj;

import annotation.Accept;

import java.util.Scanner;

/**
 * 4148 生理周期
 * <p>
 * 描述
 * 人生来就有三个生理周期，分别为体力周期、感情周期和智力周期，它们的周期长度分别为23天、28天和33天。每一个周期中有一天是高峰。在高峰这天，人会在相应的方面表现出色。例如，在智力周期的高峰，人会思维敏捷，注意力容易高度集中。因为三个周期的长度不同，所以通常三个周期的高峰不会落在同一天。对于每个人，想知道何时三个高峰落在同一天。对于每个周期，会给出从当前年份的第一天开始，到出现高峰的天数（不一定是第一次高峰出现的时间）。给定一个从当年第一天开始的天数，你的任务是输出从给定时间开始（不包括给定时间），下一次三个高峰落在同一天的时间（距给定时间的天数）。例如：给定时间为10，下次出现三个高峰同一天的时间是12，则输出2（注意这里不是3）。
 * <p>
 * 输入
 * 输入包含多组数据，每一组数据由四个整数组成，数据以-1 -1 -1 -1 结束。
 * 对于四个整数p, e, i和d，p, e, i分别表示体力、情感和智力高峰出现的时间（时间从当年的第一天开始计算）。d是给定的时间，可能小于p, e或i。所有给定时间是非负的并且小于或等于365，所求的时间小于或等于21252。
 * 输出
 * 从给定时间起，下一次三个高峰同一天的时间（距离给定时间的天数）。
 *
 * @author XieLongzhen
 * @date 2019/8/2 14:30
 */
@Accept
public class MenstrualCycle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p, e, i, d, count = 0;
        int j, k = 0;
        while (true) {
            p = scanner.nextInt();
            e = scanner.nextInt();
            i = scanner.nextInt();
            d = scanner.nextInt();

            if (p != -1) {
                count++;
                for (j = d + 1; j < 21252; j++) {
                    if ((j - p) % 23 == 0) {
                        break;
                    }
                }
                for (; j < 21252; j = j + 23) {
                    if ((j - e) % 28 == 0) {
                        break;
                    }
                }
                for (; j < 21252; j = j + 23 * 28) {
                    if ((j - i) % 33 == 0) {
                        break;
                    }
                }
                k++;
                System.out.println(String.format("Case %d: the next triple peak occurs in %d days.", k, j - d));
            } else {
                break;
            }
        }
    }
}
