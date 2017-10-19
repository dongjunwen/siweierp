package com.fangxin.siwei.fangzhi.shiro;


import com.fangxin.siwei.fangzhi.modal.SysUser;
import com.fangxin.siwei.fangzhi.modal.User;
import com.fangxin.siwei.fangzhi.service.UserService;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Date:2017/10/19 0019 15:08
 * @Author lu.dong
 * @Description：
 **/
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    SysUserService sysUserService;

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //存放登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        SysUser sysUser = sysUserService.login(username);
        if(sysUser!=null){
            //放入shiro.调用CredentialsMatcher检验密码
            return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), getName());
        }
        return null;
    }

    /**
     * 用于获取认证成功后的角色、权限等信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

}
