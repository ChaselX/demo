package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XieLongZhen
 * @time 2017/12/27 16:30
 */
public class test {

    static class A{
        private List<Integer> list;

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        A(){

        }
        A(List<Integer> list){
            this.list = list ;
        }
    }

    static class B extends A{
        B(A a){
            this.setList(a.list);
        }

    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>(){{
            add(2);
            add(4);
            add(3);
            add(6);
            add(5);
            add(4);
            add(3);
            add(2);
        }};
        List<Integer> list1 = new ArrayList<Integer>(){};

        A a = new A(list);
        B b = new B(a);

        System.out.println(a.getList());
        a.setList(list1);
        System.out.println(b.getList());
        System.out.println(a.getList());

    }
}
