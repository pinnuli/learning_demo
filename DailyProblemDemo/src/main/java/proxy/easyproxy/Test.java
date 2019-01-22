package proxy.easyproxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Move m = (Move) Proxy.newProxyInstance(Move.class, h);
        m.move();
    }
}
