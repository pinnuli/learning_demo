package proxy.easyproxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: pinnuli
 * @date: 2019-01-21
 */
public interface InvocationHandler {

    public void invoke(Object o,Method m);
}
