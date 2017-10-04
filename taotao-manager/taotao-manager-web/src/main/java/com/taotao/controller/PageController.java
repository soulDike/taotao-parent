package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 首页跳转
     * @return
     */
    @RequestMapping("/")
    public String page() {
        return "index";
    }

    /**
     * 页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
