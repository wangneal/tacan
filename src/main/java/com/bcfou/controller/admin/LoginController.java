package com.bcfou.controller.admin;

import com.bcfou.entity.User;
import com.bcfou.service.UrlsiteByVisitorService;
import com.bcfou.service.VisitorService;
import com.bcfou.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



/**
 * @Author: 编程否
 * @Date: 2018/8/8 10:46
 */
@Controller
public class LoginController {
    @Autowired
    private UrlsiteByVisitorService service;
    @PostMapping("/login")
    public String login(String username, String password, Boolean rememberme, ModelMap mav){
        if (rememberme == null){
            rememberme = false;
        }
        password = (String) MD5Util.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberme);
        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(token);
            mav.addAttribute("msg", "认证成功");
            return "redirect:/admin";
        }catch (UnknownAccountException e){
            mav.addAttribute("msg", e.getMessage());
            return "login";
        }catch (AuthorizationException e){
            mav.addAttribute("msg", "认证失败");
            return "login";
        }

    }
    @GetMapping("/admin")
    @RequiresRoles("admin")
    public String admin(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        Integer visitor = service.getAllVisitors();
        model.addAttribute("visitor", visitor);
        return "/admin/index";
    }
}
