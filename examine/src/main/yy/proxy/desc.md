在业务开发中，为业务接口类中的方法处理前后添加相同的前置处理动作以及后置处理动作是很常见的场景。典型场景如：处理方法前添加日志记录，进行鉴权，记录方法处理时间等。试写出解决上述场景的具体代码，具体要求如下（20分）：
1) 可以对任意业务接口的方法进行增强，添加执行方法的前后置逻辑
2) 不修改原有业务接口以及其具体实现类
3) 前后置逻辑可以按需动态地进行选择，如：可以只添加日志记录和进行鉴权，也可以只记录方法处理时间等
4) 根据你的设计，写出上述三个典型场景中至少一个的具体实现

参考的业务接口类定义及其实现（其他接口类定义不一一列出）：

```
public interface MyBusiness {
    void xxx1(String msg);
    void xxx2(int value);
}
```

```
public class MyBusinessImpl implements MyBusiness {
    public void xxx1(String msg) {
    System.out.println(msg);
    }
    public void xxx2(int value) {
    System.out.println(value);
    }
}
```

------

得分点：

1) 利用Java动态代理或Cglib等高级实现方式实现对接口的代理，得8分

2) 利用责任链或通过对其他设计模式对增强处理进行接口抽象化，得8分

3) 根据相关设计写出任意一个典型增强场景的具体实现（日志记录，进行鉴权，记录方法处理时间），得4分