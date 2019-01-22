package proxy.easyproxy;

import java.lang.reflect.Method;

/**
 * @author: pinnuli
 * @date: 2019-01-22
 */

public class TimeHandler implements InvocationHandler {

    public Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("汽车开始行驶....");
            m.invoke(target);
            long endTime = System.currentTimeMillis();
            System.out.println("汽车结束行驶....  汽车行驶时间："
                    + (endTime - startTime) + "毫秒！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
