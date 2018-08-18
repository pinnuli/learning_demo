package com.pinnuli.spring.ioc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author: pinnuli
 * @date: 18-7-27
 */

public class BeanLifeCycle {

    public void defautInit() {
        System.out.println("Bean defautInit.");
    }

    public void defaultDestroy() {
        System.out.println("Bean defaultDestroy.");
    }
    /*@Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroy...");
    }*/

    public void start(){
        System.out.println("Bean start...");
    }

    public void stop(){
        System.out.println("Bean stop...");
    }


}
