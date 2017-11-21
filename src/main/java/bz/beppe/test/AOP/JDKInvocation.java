package bz.beppe.test.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangshangliang on 2017/10/24.
 */
public class JDKInvocation implements InvocationHandler{

    private Object target;

    public JDKInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("doPrint".equals(method.getName())){
            System.out.println("===before==="+method.getName()+"=====");
            Object result = method.invoke(target, args);
            System.out.println("===after==="+method.getName()+"====");
            return result;
        }else {
            Object result = method.invoke(target, args);
            return result;
        }

    }


    public static void main(String[] args) {
        HelloWorld helloWorld=new HelloWorldImpl();
        JDKInvocation jdkInvocation = new JDKInvocation(helloWorld);
        HelloWorld helloWorldProxy = (HelloWorld)Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), jdkInvocation);
        helloWorldProxy.doPrint();
    }
}
