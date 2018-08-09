package com.bcfou.config;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 18:51
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");//设置登录URL
        shiroFilterFactoryBean.setSuccessUrl("/index");//设置登录成功的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");//未授权的URL
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 定义filterChain，静态资源不拦截
        filterChainDefinitionMap.put("/static/css/**", "anon");
        filterChainDefinitionMap.put("/static/js/**", "anon");
        filterChainDefinitionMap.put("/static/fonts/**", "anon");
        filterChainDefinitionMap.put("/static/img/**", "anon");
        filterChainDefinitionMap.put("/link", "anon");
        filterChainDefinitionMap.put("/category", "anon");
        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "anon");

        // 除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        //配置SecurityManager并且注入shiroRealm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
    @Bean
    public MyRealm shiroRealm() {
        //此处是自己实现的Realm
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        //shiro生命周期处理器
        return new LifecycleBeanPostProcessor();
    }
    //cookie对象
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }
    /**
     * cookie管理对象
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
//    // 表示当前Subject已经通过login进行了身份验证；即Subject.isAuthenticated()返回true。
//    @RequiresAuthentication
//
//// 表示当前Subject已经身份验证或者通过记住我登录的。
//    @RequiresUser
//// 表示当前Subject没有身份验证或通过记住我登录过，即是游客身份。
//    @RequiresGuest
//// 表示当前Subject需要角色admin和user。
//    @RequiresRoles(value={"admin", "user"}, logical= Logical.AND)
//// 表示当前Subject需要权限user:a或user:b。
//    @RequiresPermissions (value={"user:a", "user:b"}, logical= Logical.OR)

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
