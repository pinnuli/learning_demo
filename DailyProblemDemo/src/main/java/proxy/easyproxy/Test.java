package proxy.easyproxy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Move m = (Move) Proxy.newProxyInstance(Move.class);
        m.move();
//        System.out.println(System.getProperty("user.dir"));
    }
}
