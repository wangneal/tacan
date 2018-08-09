package com.bcfou.controller.admin;

import com.bcfou.entity.UrlSite;
import com.bcfou.entity.Visitor;
import com.bcfou.service.UrlSiteService;
import com.bcfou.service.UrlsiteByVisitorService;
import com.bcfou.service.VisitorService;
import com.bcfou.service.impl.VisitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 访问量
 * @Author: 编程否
 * @Date: 2018/8/9 13:33
 */
@Controller
public class VisitorController {
    @Autowired
    private UrlSiteService urlSiteService;
    @Autowired
    private UrlsiteByVisitorService urlsiteByVisitorService;

    @Autowired
    private VisitorService visitorService;
    @GetMapping("/link")
    public String active(@RequestParam("id") int id){
        //TDD 这里有个问题，如果突然访问量过大，数据库压力就会很大
        UrlSite urlSite = urlSiteService.findById(id);
        Integer number;
        if (urlSite.getStatus() == 0){//判断是否激活，没有就自动激活
            urlSite.setStatus(1);
            number = 1;//没有激活代表没有访问，所以这里是第一次访问
            Visitor visitor = new Visitor();//由于是第一访问，我们的数据库中还没有记录，所以需要建立记录
            visitor.setNumber(number);
            visitor.setUrlSite(urlSite);
            visitorService.save(visitor);//保存记录
            return "redirect:/";
        }else {//如果已经激活
            Visitor visitor = urlSite.getVisitor();//获取访问量
            number = visitor.getNumber();
            visitor.setNumber(number + 1);//如果已经激活，代表已经有了记录，这时更新记录就可以了
            visitorService.save(visitor);
            return "redirect:/";//这里用重定向的方法，因为可以在首页显示了，代表已经激活了
        }
    }
}
