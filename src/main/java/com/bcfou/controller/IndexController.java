package com.bcfou.controller;

import com.bcfou.entity.Category;
import com.bcfou.entity.UrlSite;
import com.bcfou.entity.WebSite;
import com.bcfou.service.Category2UrlSiteService;
import com.bcfou.service.CategoryService;
import com.bcfou.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 5:16
 */
@Controller
public class IndexController {
    @Autowired
    private WebSiteService webSiteService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Category2UrlSiteService category2UrlSiteService;
    @GetMapping("/")
    public String index(Model model){
        List<Category> categories = categoryService.findAll();
        List<WebSite> webSites = webSiteService.findAll();

        WebSite webSite = new WebSite();
        if (webSites.size() == 1){
            webSite = webSites.get(0);
        }
        model.addAttribute("category", categories);
        model.addAttribute("website", webSite);
        for (Category category : categories){
            List<UrlSite> urlSites = category2UrlSiteService.findByCategoryName(category.getName());
        }
        return "index";
    }

    @GetMapping("/category")
    public String category(Model model, @RequestParam("id") int id){
        Category category = categoryService.findById(id);
        List<UrlSite> urlSites = category2UrlSiteService.findByCategoryName(category.getName());
        model.addAttribute("category", category);
        model.addAttribute("urlsite", urlSites);
        return "category";
    }
    @GetMapping("/register")
    public String regidter(Model model){
        //用户登记网址
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model, @RequestParam("name") String sitename, @RequestParam("url") String siteurl, @RequestParam("category") int cid){
        //用户登记网址
        Category category = categoryService.findById(cid);
        List<UrlSite> urlSites = new ArrayList<>();
        UrlSite urlSite = new UrlSite();
        urlSite.setSitename(sitename);
        urlSite.setSiteurl(siteurl);
        urlSites.add(urlSite);
        category.setUrlSites(urlSites);
        Category result = categoryService.save(category);
        if (result != null){
            model.addAttribute("msg", "添加成功，请尽快在贵站加入友链，第一次访问成功即自动审核！");
        }else {
            model.addAttribute("msg", "系统出了些问题，请联系管理员！");
        }
        return "register";
    }
}
