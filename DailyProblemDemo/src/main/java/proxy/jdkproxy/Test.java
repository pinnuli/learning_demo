package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Test {

    /**
     * JDK动态代理测试类
     */
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler th = new TimeHandler(car);
        Class<?> cls = car.getClass();
        /**
         * loader  类加载器
         * interfaces  实现接口
         * th InvocationHandler
         */
        Move t = (Move) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), th);
        InvocationHandler mh = new LogHandler(t);
        Class<?> proxyCls = t.getClass();
        Move l = (Move) Proxy.newProxyInstance(proxyCls.getClassLoader(), proxyCls.getInterfaces(), mh);
        l.move();
    }

}
