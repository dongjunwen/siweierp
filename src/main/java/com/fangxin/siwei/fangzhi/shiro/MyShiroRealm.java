package com.fangxin.siwei.fangzhi.shiro;


import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.UserService;
import com.fangxin.siwei.fangzhi.service.system.SysRoleResourceService;
import com.fangxin.siwei.fangzhi.service.system.SysRoleService;
import com.fangxin.siwei.fangzhi.service.system.SysUserRoleService;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Date:2017/10/19 0019 15:08
 * @Author lu.dong
 * @Description：
 **/
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserRoleService sysUserRoleService;
   // @Autowired
   // SysRoleService sysRoleService;
    @Autowired
    SysRoleResourceService sysRoleResourceService;

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
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String userNo = user.getUserNo();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        List<SysUserRole> roleList = sysUserRoleService.selectByUserNo(userNo);
        Set<String> roleSet = new HashSet<String>();
        for(SysUserRole role : roleList){
            roleSet.add(role.getRoleCode());
        }
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
        List<SysRoleResource> permissionList = sysRoleResourceService.selectByUserNo(userNo);
        Set<String> permissionSet = new HashSet<String>();
        for(SysRoleResource Permission : permissionList){
            permissionSet.add(Permission.getSourceNo());
        }
        info.setStringPermissions(permissionSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
		/*List<TSysResource> objectPermissions = tSysResourceService.selectBySourceList(permissionSet);
		Set<MyShiroPermit> permissionSets = new HashSet<MyShiroPermit>();
		Collections.sort(objectPermissions, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				return ((TSysResource) o1).getSortOrder()-((TSysResource) o2).getSortOrder();
			}
		});
		for(TSysResource sysResource : objectPermissions){
			MyShiroPermit myShiroPermit=new MyShiroPermit();
			myShiroPermit.setPermitCode(sysResource.getSourceNo());
			myShiroPermit.setPermitUrl(sysResource.getReqUrl());
			permissionSets.add(myShiroPermit);
		}
		info.addObjectPermissions(permissionSets);*/
        return info;
    }

}
