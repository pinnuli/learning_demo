package com.pinnuli.spring.ioc.autowiring;

/**
 * @author: pinnuli
 * @date: 18-7-28
 */

public class AutoWiringService {

    private AutoWiringDAO autoWiringDAO;

    public AutoWiringService(AutoWiringDAO autoWiringDAO) {
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
        System.out.println("setAutoWiringDAO");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String word) {
        this.autoWiringDAO.say(word);
    }
}
