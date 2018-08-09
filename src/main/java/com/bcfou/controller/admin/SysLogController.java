package com.bcfou.controller.admin;

import com.bcfou.entity.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 4:24
 */
@Controller
@RequestMapping("/admin")
public class SysLogController {
    private static final Logger log = LoggerFactory.getLogger(SysLogController.class);
    @GetMapping("/log")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<>();
        String filepath = "H:/ideaprojects/tacan/log/error." + sdf1.format(new Date()) + ".log";
        log.info(filepath);
        try {
            String encoding = "UTF-8";
            File file = new File(filepath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                read.close();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("log", list);
        return "/admin/log";
    }
}