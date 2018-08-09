package com.bcfou.controller.admin;

import com.bcfou.entity.User;
import com.bcfou.service.UserService;
import com.bcfou.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户
 * @Author: 编程否
 * @Date: 2018/8/8 22:39
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public String edit(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "/admin/useredit";
    }

    @PostMapping("/userupdate")
    public String update(Model model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("mail") String mail){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        password = MD5Util.encrypt(username, password);
        user.setUserName(username);
        user.setPassword(password);
        user.setMail(mail);
        User result = userService.save(user);
        if (result != null){
            model.addAttribute("msg", "修改成功，感谢使用,请重新登录");
            return "/admin/useredit";
        }else {
            model.addAttribute("msg", "用户名或密码中不能含有特殊字符或为空！");
            return "/admin/useredit";
        }
    }
}
