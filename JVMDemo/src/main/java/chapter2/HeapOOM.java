package chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: pinnuli
 * @date: 2018-11-27
 */

public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
            System.out.println(list.size());
        }
    }
}
