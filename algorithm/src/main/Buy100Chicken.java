import java.util.Scanner;

/**
 * 百钱买百鸡问题
 * • 鸡翁一值钱五, 鸡母一值钱三, 鸡雏三值钱一.
 * <p>
 * 百钱买百鸡, 问鸡翁, 鸡母, 鸡雏各几何
 * —— 张丘建《算经》
 * <p>
 * 求解方法:
 * • 先构造可能的解的集合S={(X,Y,Z)|0<=X,Y,Z<=100}
 * <p>
 * X, Y, Z分别代表买公鸡,母鸡和小鸡的只数
 * • 然后验证条件X+Y+Z=100, 5X+3Y+Z/3=100
 * <p>
 * • 复杂度: O(1002) 
 *
 * @author XieLongzhen
 * @date 2019/8/2 10:25
 */
public class Buy100Chicken {
    private static void origin(int x, int y, int z) {
        for (x = 0; x < 20; x++) {
            for (y = 0; y < 33; y++) {
                for (z = 0; z < 100; z++) {
                    if (x + y + z == 100 && (15 * x + 9 * y + z == 300)) {
                        System.out.print(x + ",");
                        System.out.print(y + ",");
                        System.out.println(z);
                    }
                }
            }
        }
    }

    private static void improve(int x, int y, int z) {
        for (x = 0; x < 20; x++) {
            for (y = 0; y < 33; y++) {
                z = 100 - x - y;
                if (x + y + z == 100 && (15 * x + 9 * y + z == 300)) {
                    System.out.print(x + ",");
                    System.out.print(y + ",");
                    System.out.println(z);
                }
            }
        }
    }

    public static void main(String[] args) {
        int x = 0, y = 0, z = 0;
        improve(x, y, z);
    }
}
