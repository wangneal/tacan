package com.bcfou.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理页面
 * @Author: 编程否
 * @Date: 2018/8/9 15:54
 */
@ControllerAdvice
public class GloableHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorView(HttpServletRequest resquest, Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", resquest.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
