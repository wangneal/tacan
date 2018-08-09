package com.bcfou.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 19:27
 */
public class MD5Util {
    private static String hashAlgorithName = "MD5";
    private static String salt = "bcfou.com";
    private static int hashIterations = 1024;//加密次数
    public static String encrypt(String userName, String password){
        ByteSource source = ByteSource.Util.bytes(userName + salt);//将用户名和盐混合生成新的盐
        String obj = new SimpleHash(hashAlgorithName, password, source, hashIterations).toHex();
        return obj;
    }
    public static void main(String[] args){
        Object password = MD5Util.encrypt("admin", "123456");
        System.out.println(password.toString());
    }
}
