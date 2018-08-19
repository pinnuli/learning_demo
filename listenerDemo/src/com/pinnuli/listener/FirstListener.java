package com.pinnuli.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author pinnuli
 */
@javax.servlet.annotation.WebListener()
public class FirstListener implements ServletContextListener{

    /**
     *
     *Public constructor is required by servlet spec
     */
    public FirstListener() {
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        String initParam = sce.getServletContext().getInitParameter("initParam");
        System.out.println("contextInitiallzed: + initParam:" + initParam);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
      System.out.println("contextDestoryed");
    }

}
