package com.bcfou.controller.admin;

import com.bcfou.entity.Category;
import com.bcfou.entity.UrlSite;
import com.bcfou.entity.User;
import com.bcfou.service.Category2UrlSiteService;
import com.bcfou.service.CategoryService;
import com.bcfou.service.UrlSite2CategoryService;
import com.bcfou.service.UrlSiteService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 网址操作类
 * @Author: 编程否
 * @Date: 2018/8/8 21:12
 */
@Controller
@RequestMapping("/admin")
public class UrlSiteController {
    @Autowired
    private Category2UrlSiteService siteService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UrlSite2CategoryService urlSite2CategoryService;
    @Autowired
    private UrlSiteService urlSiteService;
    private static final Logger log = LoggerFactory.getLogger(UrlSiteController.class);
    @GetMapping("/urls")
    public String index(Model model, @RequestParam(value = "p", defaultValue = "0") int p, @RequestParam(value = "size", defaultValue = "20") int size){
        //网址管理首页方法
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(p, size, sort);
        Page<UrlSite> urlSitePage = urlSiteService.findAll(pageable);
        model.addAttribute("page", urlSitePage);
        return "admin/urls";
    }
    @GetMapping("/urlsupdate")
    public String update(Model model, @RequestParam("id") int id){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        UrlSite urlSite = urlSiteService.findById(id);
        model.addAttribute("urlsite", urlSite);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return "admin/urlsedit";
    }
    @PostMapping("/urlsupdate")
    public String update(Model model, @RequestParam("sitename") String sitename, @RequestParam("siteurl") String siteurl, @RequestParam("status") int status, @RequestParam("category") int cid){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        UrlSite urlSite = urlSiteService.findBySitename(sitename);
        model.addAttribute("urlsite", urlSite);
        urlSite.setSitename(sitename);
        urlSite.setSiteurl(siteurl);
        urlSite.setStatus(status);
        List<UrlSite> urlSites = new ArrayList<>();
        urlSites.add(urlSite);
        Category category = categoryService.findById(cid);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        category.setUrlSites(urlSites);
        Category result = categoryService.save(category);

        if (result != null){
            model.addAttribute("msg", "更新成功！");

            return "admin/urlsedit";
        }else {
            model.addAttribute("msg", "出错了！");
            return "admin/urlsedit";
        }
    }

    @RequestMapping("/urlsdelete")
    public String delete(@RequestParam("id") int id, Model model, @RequestParam(value = "p", defaultValue = "0") int p, @RequestParam(value = "size", defaultValue = "20") int size){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        UrlSite result = urlSiteService.findById(id);
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(p, size, sort);
        Page<UrlSite> urlSitePage = urlSiteService.findAll(pageable);
        model.addAttribute("page", urlSitePage);
        if (result != null){
            urlSiteService.deleteById(id);
            model.addAttribute("msg", "删除成功");
            Page<UrlSite> pages = urlSiteService.findAll(pageable);
            model.addAttribute("page", pages);
            return "admin/urls";
        }else {
            model.addAttribute("msg", "哎呀，出错了！");
            return "admin/urls";
        }
    }

}
