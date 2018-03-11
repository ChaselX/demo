package vip.compressSpaceAndReversePrintString;

/**
 * @author XieLongZhen
 * @time 2018/3/8 15:49
 */
public class compressSpaceAndReversePrintString {
    public static String testStr = "abc   def efg";

    public static void main(String[] args) {
        char[] chars = testStr.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ' && i != 0) {
                if (chars[i - 1] == ' ') {
                    continue;
                }
            }
            System.out.print(chars[i]);
        }
    }
}
