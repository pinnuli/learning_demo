package proxy.cglibproxy;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Test {

    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        Train t = (Train)proxy.getProxy(Train.class);
        t.move();
    }
}
