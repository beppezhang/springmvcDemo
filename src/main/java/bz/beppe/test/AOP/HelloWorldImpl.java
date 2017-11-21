package bz.beppe.test.AOP;

/**
 * Created by zhangshangliang on 2017/10/23.
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void doPrint() {
        System.out.println("打印了日志！！！");

    }

    @Override
    public void printHelloWorld() {
        System.out.println("打印了helloworld的日志！！！");

    }
}
