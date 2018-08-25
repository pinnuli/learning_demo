package com.pinnuli.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: pinnuli
 * @date: 18-8-25
 */
@Controller
@RequestMapping("/hello")
public class HelloMvcController {

    @RequestMapping("/mvc")
    public String helloMvc() {
        return "hello";
    }
}
