package com.pinnuli.filter;

import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "firstFilter",urlPatterns = "/*")
public class firstFilter implements javax.servlet.Filter {
    @Override
    public void destroy() {
        System.out.println("destory");
    }

    @Override
    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
//        chain.doFilter(req, resp);
        System.out.println("start dofilter");
    }

    @Override
    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("init");
    }

}
