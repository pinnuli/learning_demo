package com.pinnuli.controller;

import com.pinnuli.bean.Message;
import com.pinnuli.entity.Page;
import com.pinnuli.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-8-27
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private Message message;
    private Page page;

    @RequestMapping(value = "/messageList", method = RequestMethod.GET)
    public String messageList(Map<String, Object> model) {
        /*message.setCommand("");
        message.setDescription("");
        page.setCurrentPage(1);
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("message", message);
        parameter.put("page", page);*/
        model.put("messageList", messageService.queryMessageList());
        return "/back/list";
    }
}
