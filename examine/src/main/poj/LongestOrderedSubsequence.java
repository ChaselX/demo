package poj;

import annotation.Accept;

import java.util.Scanner;

/**
 * Unpass
 * <p>
 * 2533:Longest Ordered Subsequence
 * <p>
 * 描述
 * A numeric sequence of ai is ordered if a1 < a2 < ... < aN.
 * Let the subsequence of the given numeric sequence (a1, a2, ..., aN) be any sequence (ai1, ai2, ..., aiK),
 * where 1 <= i1 < i2 < ... < iK <= N. For example, sequence (1, 7, 3, 5, 9, 4, 8) has ordered subsequences,
 * e. g., (1, 7), (3, 4, 8) and many others.
 * All longest ordered subsequences are of length 4, e. g., (1, 3, 5, 8).
 * <p>
 * Your program, when given the numeric sequence, must find the length of its longest ordered subsequence.
 * <p>
 * 输入
 * The first line of input file contains the length of sequence N.
 * The second line contains the elements of sequence - N integers in the range from 0 to 10000 each,
 * separated by spaces. 1 <= N <= 1000
 * <p>
 * 输出
 * Output file must contain a single integer - the length of the longest ordered subsequence of the given sequence.
 *
 * @author XieLongzhen
 * @date 2019/8/3 15:44
 */
@Accept
public class LongestOrderedSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int maxLen = 1;
        int[] nums = new int[N];
        int[] lens = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        lens[0] = 1;
        for (int i = 1; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lens[j] > tmp) {
                        tmp = lens[j];
                    }
                }
            }
            lens[i] = tmp + 1;
            if (maxLen < lens[i]) {
                maxLen = lens[i];
            }
        }
        System.out.println(maxLen);
    }
}
