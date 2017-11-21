package bz.beppe.test.AOP;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangshangliang on 2017/10/24.
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("++++++ before"+methodProxy.getSuperName());
//        System.out.println(method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("++++++ before" +methodProxy.getSuperName());
        return null;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorldImpl.class);
        enhancer.setCallback(cglibProxy);

        HelloWorldImpl o = (HelloWorldImpl)enhancer.create();
//        System.out.println(o.getId());
        o.doPrint();
    }
}
