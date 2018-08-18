package com.pinnuli.spring.ioc.beanannotation.multibean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author: pinnuli
 * @date: 18-7-28
 */
@Qualifier("beanImpl")
@Component
public class BeanImplThree implements BeanInterface{
}
