package sort;

import java.util.LinkedList;
import java.util.List;

/**
 * @author XieLongZhen
 * @time 2018/1/9 17:13
 */
public class sortListImpl {

    /**
     * 快速排序
     *
     * @param list
     * @param low
     * @param high
     */
    public static void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int point = partition(list, low, high);
            quickSort(list, low, point - 1);
            quickSort(list, point + 1, high);
        }
    }

    private static int partition(List<Integer> list, int low, int high) {
        int key = list.get(low);
        while (low < high) {
            while (low < high && list.get(high) >= key) {
                --high;
            }
            swap(list, low, high);
            while (low < high && list.get(low) <= key) {
                ++low;
            }
            swap(list, low, high);
        }
        return low;
    }

    /**
     * 将列表中两个位置的对象互换
     *
     * @param list
     * @param low
     * @param high
     */
    private static void swap(List<Integer> list, int low, int high) {
        Integer num1 = list.get(high);
        Integer num2 = list.get(low);
        list.set(low, num1);
        list.set(high, num2);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>() {
            {
                add(52);
                add(34);
                add(14);
                add(22);
                add(9);
                add(24);
                add(7);
            }
        };
        quickSort(list, 0, list.size() - 1);
        System.out.println(list);
    }
}
