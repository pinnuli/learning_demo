package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class LogHandler implements InvocationHandler {

    public Object target;

    public LogHandler(Object target) {
        super();
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志代理开始....");
        method.invoke(target);
        System.out.println("日志代理结束");
        return null;
    }

}
