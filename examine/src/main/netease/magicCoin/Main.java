package netease.magicCoin;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author XieLongZhen
 * @time 2018/3/20 11:35
 */
public class Main {

    static Long choose(Long n, Stack stack) {
        if (n % 2 == 0) {
            stack.push("2");
            n = (n - 2) / 2;
        } else {
            stack.push("1");
            n = (n - 1) / 2;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        Stack<String> stack = new Stack<>();
        while (n != 0) {
            n = choose(n, stack);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
