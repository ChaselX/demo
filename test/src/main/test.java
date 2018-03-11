/**
 * @author XieLongZhen
 * @time 2018/3/7 12:07
 */
public class test {
    static int j = -1;
    static void f(int[] a){
        do {
            j += 1;
            a[j] += a[j + 1];
        } while (j < 2);
    }

    public static void main(String[] args) {
        int k;
        int[] a = {1, 2, 3, 4, 5};
        for (k = 1; k<3;k++){
            f(a);
        }
        for (k=0;k<5;k++){
            System.out.print(a[k]);
            System.out.println();
        }
    }
}