package com.pinnuli.spring.ioc.beanannotation.javabeased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: pinnuli
 * @date: 18-7-29
 */

@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {

    @Bean(name = "store", initMethod = "init", destroyMethod = "destory")
    public BeanStore beanStore() {
        return new BeanStore();
    }

    @Value("${url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public MyDriverManager myDriverManager() {
        return new MyDriverManager(url, username, password);
    }
}
