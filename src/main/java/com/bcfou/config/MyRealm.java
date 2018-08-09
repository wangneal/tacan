package com.bcfou.config;

import com.bcfou.entity.Permission;
import com.bcfou.entity.Role;
import com.bcfou.entity.User;
import com.bcfou.service.RolePermissionService;
import com.bcfou.service.UserRoleService;
import com.bcfou.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 18:51
 */
public class MyRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    //获取用户角色和权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUserName();
        log.info("用户{}获取权限------------->MyRealm.doGetAuthorizationInfo",username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取用户角色集
        List<Role> roles = userRoleService.findByUserName(username);
        Set<String> roleSet = new HashSet<>();
        for (Role role : roles){
            roleSet.add(role.getName());
        }
        info.addRoles(roleSet);
        //获取用户权限集
        List<Permission> permissions = rolePermissionService.findByUserName(username);
        Set<String> permissionSet = new HashSet<>();
        for (Permission permission : permissions){
            permissionSet.add(permission.getAuthority());
        }
        info.addStringPermissions(permissionSet);
        return info;
    }
    //用户登录认证授权
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        log.info("用户{}正在认证------------->MyRealm.doGetAuthenticationInfo", username);

        User user = userService.findByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
