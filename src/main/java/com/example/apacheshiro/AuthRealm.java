package com.example.apacheshiro;

import com.example.apacheshiro.model.Permission;
import com.example.apacheshiro.model.Role;
import com.example.apacheshiro.model.User;
import com.example.apacheshiro.service.UserService;
import com.example.apacheshiro.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Author zeroback13
 * @Date 2021/4/5 2:53
 * @Version 1.0
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //用户授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User)principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if(!CollectionUtils.isEmpty(roleSet)){
            for (Role role : roleSet) {
                roleNameList.add(role.getRname());
                Set<Permission> permissions = role.getPermissions();
                if(!CollectionUtils.isEmpty(permissions)){
                    for (Permission p : permissions) {
                        permissionList.add(p.getName());
                    }

                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
