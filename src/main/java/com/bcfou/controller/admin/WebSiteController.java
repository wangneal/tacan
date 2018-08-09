package com.bcfou.controller.admin;

import com.bcfou.entity.User;
import com.bcfou.entity.WebSite;
import com.bcfou.service.WebSiteService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 网站设置控制类
 * @Author: 编程否
 * @Date: 2018/8/8 21:15
 */
@Controller
@RequestMapping("/admin")
public class WebSiteController {
    @Autowired
    private WebSiteService webSiteService;
    private static final Logger log = LoggerFactory.getLogger(WebSiteController.class);
    @GetMapping("/website")
    @RequiresRoles("admin")
    public String index(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        List<WebSite> webSites = webSiteService.findAll();
        WebSite webSite = new WebSite();
        if (webSites.size() != 0){
            webSite = webSites.get(0);
            model.addAttribute("website", webSite);
        }
        return "/admin/website";
    }

    @PostMapping("/website")
    @RequiresRoles("admin")
    public String update(Model model, @RequestParam("webname") String webname, @RequestParam("webdescribe") String webdescribe){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        List<WebSite> webSites = webSiteService.findAll();
        WebSite webSite = new WebSite();
        if (webSites.size() != 0){
            webSite = webSites.get(0);
            model.addAttribute("website", webSite);
        }
        webSite.setWebname(webname);
        webSite.setWebdescribe(webdescribe);
        WebSite result = webSiteService.save(webSite);
        if (result != null){
            model.addAttribute("msg", "修改成功，感谢使用。");
            return "/admin/website";
        }else {
            model.addAttribute("msg", "修改失败，请联系管理员！");
            return "/admin/website";
        }
    }
}
