package com.bcfou.controller.admin;

import com.bcfou.entity.Category;
import com.bcfou.entity.UrlSite;
import com.bcfou.entity.User;
import com.bcfou.service.Category2UrlSiteService;
import com.bcfou.service.CategoryService;
import com.bcfou.service.impl.Category2UrlSiteServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类目录控制类
 * @Author: 编程否
 * @Date: 2018/8/8 19:14
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Category2UrlSiteService category2UrlSiteService;
    private Logger log = LoggerFactory.getLogger(CategoryController.class);
    @GetMapping("/category")
    @RequiresRoles("admin")
    public String index(Model model){
        log.info("进入category.index（）方法，返回category页面");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("page", categories);
        return "/admin/category";
    }

    @GetMapping("/delete")
    @RequiresRoles("admin")
    public String delete(@RequestParam("id") int id, Model model){
        //分类信息删除
        log.info("进入category.delete方法");
        Category category = categoryService.findById(id);
        List<UrlSite> urlSites = category2UrlSiteService.findByCategoryName(category.getName());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);

        if (urlSites.size() != 0){
            model.addAttribute("msg", "该类目下有网址，不能删除");
            List<Category> categories = categoryService.findAll();
            model.addAttribute("page", categories);
            return "/admin/category";
        }else {
            categoryService.deleteById(id);
            List<Category> categories = categoryService.findAll();
            model.addAttribute("page", categories);
            model.addAttribute("msg", "删除成功");
            return "/admin/category";
        }

    }
    @GetMapping("/update")
    @RequiresRoles("admin")
    public String update(Model model, @RequestParam("id") int id ){
        log.info("进入category.update方法，返回修改页面");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/admin/categoryedit";
    }

    @PostMapping("/update")
    @RequiresRoles("admin")
    public String update(Model model, @RequestParam("id") int id, @RequestParam("name") String name){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        log.info("进入category.update方法，开始修改分类信息！");
        model.addAttribute("user", user);
        //先将分类信息查出来
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);

        //设置新的数据
        category.setName(name);
        //进行保存
        Category c = categoryService.save(category);
        //判断是否成功
        if (c != null){
            model.addAttribute("msg", "修改成功，感谢使用");
            return "/admin/categoryedit";
        }else {
            model.addAttribute("msg", "保存失败，请联系管理员处理！");
            return "/admin/categoryedit";
        }
    }

    @GetMapping("/add")
    @RequiresRoles("admin")
    public String add(Model model){
        //添加分类的方法
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "admin/add";
    }
    @PostMapping("/add")
    @RequiresRoles("admin")
    public String add(Model model,@RequestParam("name") String name){
        //添加分类的方法
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        Category category = new Category();
        category.setName(name);
        Category result = categoryService.save(category);
        if (result != null){
            model.addAttribute("msg", "添加成功，感谢使用");
            return "admin/add";
        }else {
            model.addAttribute("msg", "出错了，请联系管理员！");
        }
        return "admin/add";
    }

}
