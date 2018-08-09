package com.bcfou.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 4:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReadTest {
    private static final Logger log = LoggerFactory.getLogger(FileReadTest.class);
    @Test
    public void ReadTest(){
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd" );
        String filepath = "H:/ideaprojects/tacan/log/error." + sdf1.format(new Date()) + ".log";
        log.info(filepath);
        List<String> list = new ArrayList<>();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
