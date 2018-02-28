package insertTest;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;


/**
 * @author XieLongZhen
 * @time 2018/2/26 18:26
 */
public class SetInsertTest {

    static void hashSetTest() {
        long startTime = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        initialSet(set);
        long endTime = System.currentTimeMillis();
        System.out.println("HashSet添加100万个整数运行时间为：" + (endTime - startTime) + "ms");
    }

    static void treeSetTest() {
        long startTime = System.currentTimeMillis();
        Set<Integer> set = new TreeSet<>();
        initialSet(set);
        long endTime = System.currentTimeMillis();
        System.out.println("TreeSet添加100万个整数运行时间为：" + (endTime - startTime) + "ms");
    }

    static void linkedHashSetTest() {
        long startTime = System.currentTimeMillis();
        Set<Integer> set = new LinkedHashSet<>();
        initialSet(set);
        long endTime = System.currentTimeMillis();
        System.out.println("LinkedHashSet添加100万个整数运行时间为：" + (endTime - startTime) + "ms");
    }

    static void initialSet(Set<Integer> set) {
        for (int i = 0; i < 1000000; i++) {
            set.add(i);
        }
    }

    public static void main(String[] args) {
        linkedHashSetTest();
        hashSetTest();
        treeSetTest();
    }
}
