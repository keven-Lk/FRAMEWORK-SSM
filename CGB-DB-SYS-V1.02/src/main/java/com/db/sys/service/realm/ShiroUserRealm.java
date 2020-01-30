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
	//��ȡһ����־����
	private Logger log = Logger.getLogger(SysUserServiceImpl.class);


	//���ü���ƥ����
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//����ƾ֤ƥ�����
		HashedCredentialsMatcher hMatcher = new HashedCredentialsMatcher();
		//���ü����㷨
		hMatcher.setHashAlgorithmName("MD5");
		//���ü��ܴ���
		hMatcher.setHashIterations(1);
		super.setCredentialsMatcher(hMatcher);
	}
	/**
	 * ������֤��Ϣ�Ļ�ȡ�Լ���װ
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		log.info("�����������");
		//1.��ȡ�û�������û���Ϣ
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String username= uToken.getUsername();
		//2.�����û�����ѯ���ݿ�
		SysUser user = sysUserDao.findUserByUserName(username);
		//3.�ж��û��Ƿ����
		if(user == null)
			throw new UnknownAccountException();
		//4.�ж��û��Ƿ��Ѿ�����
		if(user.getValid() == 0)
			throw new LockedAccountException();
		//5.��װ�û���Ϣ
		ByteSource credentialsSalt = 
				ByteSource.Util.bytes(user.getSalt());
		//��ס:����ʲô����Ҫ�������ķ���ֵ
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user,//principal(�û����)
				user.getPassword(),//hashedCredentials �Ѽ��ܵ�bean
				credentialsSalt,//credentialsSalt�Ѿ��ӹ��õ�salt����
				getName());//realmName
		//6.���ط�װ���
		return info;//����ֵ�ᴫ�ݸ���֤������(������֤��������ͨ������Ϣ�����֤����)
	}


	/**
	 * ������Ȩ��Ϣ�Ļ�ȡ�Լ���װ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//1.��ȡ��¼�û���Ϣ�������û�id
		SysUser user=(SysUser)principals.getPrimaryPrincipal();
		Integer userId=user.getId();
		//2.�����û�id��ȡ�û�ӵ�еĽ�ɫ(sys_user_roles)
		List<Integer> roleIds=
				sysUserRoleDao.findRoleIdsByUserId(userId);
		if(roleIds==null||roleIds.size()==0)
			throw new AuthorizationException();
		//3.���ڽ�ɫid��ȡ�˵�id(sys_role_menus)
		Integer[] array={};
		List<Integer> menuIds=
				sysRoleMenuDao.findMenuIdsByRoleIds(
						roleIds.toArray(array));
		if(menuIds==null||menuIds.size()==0)
			throw new AuthorizationException();
		//4.���ڲ˵�id��ȡȨ�ޱ�ʶ(sys_menus)
		List<String> permissions=
				sysMenuDao.findPermissions(
						menuIds.toArray(array));
		if(permissions == null||permissions.size()==0)
			throw new AuthenticationException();
		//5.��Ȩ�ޱ�ʶ��Ϣ���з�װ������
		//5.1ȡ���ظ���Ȩ�ޱ�ʾ
		Set<String> set=new HashSet<>();
		for(String per:permissions){
			if(!StringUtils.isEmpty(per)){
				set.add(per);
			}
		}
		//5.2��װ
		SimpleAuthorizationInfo info=
				new SimpleAuthorizationInfo();
		info.setStringPermissions(set);
		return info;//���ظ���Ȩ������

	}


}
