package com.bcfou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 22:57
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
}
