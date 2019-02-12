package com.ty.common.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义权限匹配和账号密码匹配
 *
 * @author tianyi
 * @since 2019-02-11
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userInfo = (String) principals.getPrimaryPrincipal();
        log.info(userInfo);
        authorizationInfo.setRoles(new HashSet<>());
        Set<String> rules = new HashSet<>();
        rules.add("test:read:list");
        authorizationInfo.setStringPermissions(rules);
        return authorizationInfo;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     *
     * @param token 身份验证令牌
     * @return 身份验证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("token.getCredentials()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

        // 密码匹配器直接返回true, 让Shiro跳过密码匹配
//        setCredentialsMatcher((authToken, authInfo) -> true);
        return new SimpleAuthenticationInfo(username, "123456", null, getName());
    }

}
