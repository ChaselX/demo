package classLoadAndInitialize.runtimeClassAndCompileClass;

/**
 * 输出结果：
 * init A：
 * draw var:0
 * init B：
 * draw var:2
 *
 * 创建B类对象的时候调用父类A的构造器，虽然编译时类型为A，但是运行时类型却为B。
 * 因此虽然A()的构造函数使用this.print()，但仍然指向的是B.print()。
 * Java的运行时动态绑定机制会为其调用正确的B.print()方法
 *
 * @author XieLongZhen
 * @time 2017/12/27 16:30
 */
class A {
    void print(){
        System.out.println("draw A");
    }
    A(){
        System.out.println("init A：");
        this.print();
    }
}
public class B extends A {

    int var = 2;

    @Override
    void print(){
        System.out.println("draw var:" + var);
    }
    B(int var){
        System.out.println("init B：");
        print();
    }

    public static void main(String[] args) {
        new B(3);
    }
}
