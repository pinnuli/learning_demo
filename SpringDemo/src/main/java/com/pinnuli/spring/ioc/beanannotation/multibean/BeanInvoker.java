package com.pinnuli.spring.ioc.beanannotation.multibean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-7-28
 */

@Component
public class BeanInvoker implements BeanInterface{

    @Autowired
    @Qualifier("beanImpl")
    private List<BeanInterface> list;

    /*@Autowired
    private BeanInterface beanInterface;*/

    public void say(){
        if (null != list && 0 != list.size()) {
            System.out.println("list...");
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        } else {
            System.out.println("List<BeanInterface> list is null !!!!!!!!!!");
        }

        /*System.out.println();

        if (null != beanInterface) {
            System.out.println(beanInterface.getClass().getName());
        } else {
            System.out.println("beanInterface is null...");
        }*/
    }
}
