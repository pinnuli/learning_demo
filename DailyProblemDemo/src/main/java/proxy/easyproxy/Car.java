package proxy.easyproxy;

import java.util.Random;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Car implements Move {

    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
