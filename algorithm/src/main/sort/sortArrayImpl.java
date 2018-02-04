package sort;

import java.util.Arrays;

/**
 * @author XieLongZhen
 * @time 2017/12/16 18:16
 */
public class sortArrayImpl {

    /**
     * 直接插入排序
     * <p>
     * 待排序记录 R1，R2，… ，Rn–1, Rn
     * 第一步：R1
     * 第二步：(R1 ), R2
     * 第三步：(R1 , R2), R3
     * ……
     * 第 j 步：(R1，R2，… ，Rj–1), Rj
     * ……
     * 第 n 步: (R1，R2，… ，Rn–1), Rn．
     * <p>
     * 稳定，不会改变相同大小元素之间排序前后的顺序
     * 时间复杂度为O(n^2)
     */
    public static void straightInsertSort(int[] arr) {
        int tmp, i, j;
        //默认初始有序表为 { arr[0] }，然后开始对剩下的无序表进行排序
        for (i = 1; i < arr.length; i++) {
            //从无序表中取出**第一个元素**
            tmp = arr[i];
            //从已排序好的有序表，从右往左遍历
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
            System.out.println(i + ":" + Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序
     * 相比于直接插入排序，他是不稳定的
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int inc = length / 2;
        while (inc >= 1) {
            shellInsertSort(arr, inc);
            inc = inc / 2;
        }
    }

    /**
     * 通过使用带有增量参数的排序方法模拟分割序列进行直接插入排序
     */
    private static void shellInsertSort(int[] arr, int inc) {
        System.out.println("--------------------------shell insert sort--------------------------");
        int tmp, i, j;
        for (i = inc; i < arr.length; i++) {
            tmp = arr[i];
            j = i - inc;
            while (j >= 0 && arr[j] > tmp) {
                arr[j + inc] = arr[j];
                j -= inc;
            }
            arr[j + inc] = tmp;
            System.out.println(inc + ":" + Arrays.toString(arr));
        }
    }

    /**
     * 简单选择排序
     * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
     * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换；
     * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
     * <p>
     * 稳定算法
     */
    public static void simpleSelectSort(int[] arr) {
        int tmp, i, j, minKey;
        for (i = 0; i < arr.length; i++) {
            //最小数的索引值minKey
            minKey = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minKey]) {
                    minKey = j;
                }
            }
            if (minKey != i) {
                tmp = arr[i];
                arr[i] = arr[minKey];
                arr[minKey] = tmp;
            }
            System.out.println(i + 1 + "：" + Arrays.toString(arr));
        }
    }

    /**
     * 简单选择排序的改进 ------ 二元选择排序
     * <p>
     * 减少循环次数
     *
     * @param arr
     */
    public static void simpleSelectSort2(int[] arr) {
        int tmp, i, j, minKey, maxKey;
        for (i = 0; i < arr.length / 2; i++) {
            minKey = maxKey = i;
            for (j = i; j < arr.length; j++) {
                if (arr[j] > arr[maxKey] && j < arr.length - i - 1) {
                    maxKey = j;
                }
                if (arr[j] < arr[minKey]) {
                    minKey = j;
                }
            }
            System.out.println("minKey = " + minKey + ", maxKey = " + maxKey + ", i= " + i);
            if (minKey != i) {
                tmp = arr[i];
                arr[i] = arr[minKey];
                arr[minKey] = tmp;
            }
            //如果先对最小值做交换操作需要考虑当maxKey与i相同的时候
            //当maxKey = i时，maxKey对应的数据已经被交换到了arr[minKey]中。
            //原序列的数据arr[i]已经和arr[minKey]位置互换了
            if (maxKey == i) {
                maxKey = minKey;
            }
            if (maxKey != arr.length - i - 1) {
                tmp = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = arr[maxKey];
                arr[maxKey] = tmp;
            }

            System.out.println(i + 1 + "：" + Arrays.toString(arr));
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        System.out.println("------------------------堆排序------------------------------");

        //建堆
        buildHeap(arr);
        //调整堆
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.println(Arrays.toString(arr));
            //将最后一个元素和堆顶元素交换位置
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            //由于只是将最后一个元素放到堆顶，因此其他元素还是相对有序的，只需要调整这个最后一个元素的位置来获得最大的元素，因此i = 0
            heapAdjust(arr, 0, i);
        }
        System.out.println("结果：" + Arrays.toString(arr));
    }

    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
    }

    /**
     * 调整堆
     *
     * @param arr
     * @param i      调整节点
     * @param length
     */
    private static void heapAdjust(int[] arr, int i, int length) {
        int tmp = arr[i];
        //因为i为从零开始的数,因此其左子数应为(i+1)*2 - 1 = 2*i +1
        int child = 2 * i + 1;
        while (child < length) {
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            if (arr[i] < arr[child]) {
                arr[i] = arr[child];
                i = child;
                child = 2 * child - 1;
            } else {
                break;
            }
            arr[i] = tmp;
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 从左往右两两比较当两个数的排序与要求相反时，将它们互换位置。将较大的数往后挪，较小的数往前调。
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        System.out.println("------------------------冒泡排序------------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + (i + 1) + "次排序：");
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 冒泡排序改进算法1
     * <p>
     * pos标志每趟排序最后一次进行交换的位置，下一次排序只需要扫描到pos的位置就可以
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        System.out.println("------------ 引入pos的冒泡排序 ---------");
        int pos = arr.length - 1;
        while (pos > 0) {
            int rec = 0;
            for (int i = 0; i < pos; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    rec = i;
                }
            }
            System.out.println(Arrays.toString(arr));
            pos = rec;
        }
    }

    /**
     * 冒泡排序改进算法2
     * <p>
     * 一次排序同时进行正向和反向冒泡
     *
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        System.out.println("----------- 正反冒泡的冒泡排序 -----------");
        int low = 0;
        int high = arr.length - 1;
        int tmp, i;
        while (low < high) {
            for (i = low; i < high; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            --high;
            for (i = high; i > low; i--) {
                if (arr[i - 1] > arr[i]) {
                    tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                }
            }
            ++low;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 21, 3, 11, 17, 4, 23, 6, 16, 7, 2, 18};
        System.out.println("初始值：" + Arrays.toString(arr));
        //直接插入排序
//        straightInsertSort(arr);
        //希尔排序
//        shellSort(arr);
        //简单选择排序
//        simpleSelectSort(arr);
        //二元选择排序
//        simpleSelectSort2(arr);
        //希尔排序
//        heapSort(arr);
        //冒泡排序
//        bubbleSort(arr);
        //冒泡排序改进算法1
//        bubbleSort1(arr);
        //冒泡排序改进算法2
//        bubbleSort2(arr);
    }
}
