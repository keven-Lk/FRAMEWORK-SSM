package com.db.sys.service.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.dao.SysUserDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysUser;
import com.db.sys.service.impl.SysUserServiceImpl;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	//获取一个日志对象
	private Logger log = Logger.getLogger(SysUserServiceImpl.class);


	//设置加密匹配器
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//构建凭证匹配对象
		HashedCredentialsMatcher hMatcher = new HashedCredentialsMatcher();
		//设置加密算法
		hMatcher.setHashAlgorithmName("MD5");
		//设置加密次数
		hMatcher.setHashIterations(1);
		super.setCredentialsMatcher(hMatcher);
	}
	/**
	 * 负责认证信息的获取以及封装
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		log.info("输入密码错误");
		//1.获取用户输入的用户信息
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String username= uToken.getUsername();
		//2.基于用户名查询数据库
		SysUser user = sysUserDao.findUserByUserName(username);
		//3.判定用户是否存在
		if(user == null)
			throw new UnknownAccountException();
		//4.判定用户是否已经锁定
		if(user.getValid() == 0)
			throw new LockedAccountException();
		//5.封装用户信息
		ByteSource credentialsSalt = 
				ByteSource.Util.bytes(user.getSalt());
		//记住:构建什么对象要看方法的返回值
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user,//principal(用户身份)
				user.getPassword(),//hashedCredentials 已加密的bean
				credentialsSalt,//credentialsSalt已经加工好的salt对象
				getName());//realmName
		//6.返回封装结果
		return info;//返回值会传递给认证管理器(后续认证管理器会通过此信息完成认证操作)
	}


	/**
	 * 负责授权信息的获取以及封装
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//1.获取登录用户信息，例如用户id
		SysUser user=(SysUser)principals.getPrimaryPrincipal();
		Integer userId=user.getId();
		//2.基于用户id获取用户拥有的角色(sys_user_roles)
		List<Integer> roleIds=
				sysUserRoleDao.findRoleIdsByUserId(userId);
		if(roleIds==null||roleIds.size()==0)
			throw new AuthorizationException();
		//3.基于角色id获取菜单id(sys_role_menus)
		Integer[] array={};
		List<Integer> menuIds=
				sysRoleMenuDao.findMenuIdsByRoleIds(
						roleIds.toArray(array));
		if(menuIds==null||menuIds.size()==0)
			throw new AuthorizationException();
		//4.基于菜单id获取权限标识(sys_menus)
		List<String> permissions=
				sysMenuDao.findPermissions(
						menuIds.toArray(array));
		if(permissions == null||permissions.size()==0)
			throw new AuthenticationException();
		//5.对权限标识信息进行封装并返回
		//5.1取出重复的权限表示
		Set<String> set=new HashSet<>();
		for(String per:permissions){
			if(!StringUtils.isEmpty(per)){
				set.add(per);
			}
		}
		//5.2封装
		SimpleAuthorizationInfo info=
				new SimpleAuthorizationInfo();
		info.setStringPermissions(set);
		return info;//返回给授权管理器

	}


}
