package com.db.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.apache.ibatis.binding.MapperMethod.MethodSignature;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.db.common.annotation.RequiredLog;
import com.db.common.utils.IPUtils;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.db.sys.entity.SysUser;
/**
 * Ŀ�귽��ִ��֮ǰ��ִ��֮��
 * 
 * @Aspect ������Ϊһ���������
 * ������־����:Ϊ����ҵ���ִ�������־��¼
 * @author Administrator
 *
 */
@Order(1)
@Service
@Aspect
public class SysLogAspect {
	/**
	 * �����������ʽ:(�����������Ϊ������չ���ܵĵ�)
	 * 1)bean(���ʽ):���ʽһ��Ϊһ��bean������,����:
	 * a)bean(sysUserServiceImpl)
	 * b)bean(*ServiceImpl)
	 * 2)annotation(���ʽ):ע�ⷽʽ���������ʽ@Pointcut("@annotation(com.db.common.annotation.RequiredLog)")
	 * 
	 */
	@Pointcut("bean(sysUserServiceImpl)")
//	@Pointcut("@annotation(com.db.common.annotation.RequiredLog)")
	public void logPointCut() {}
	/**
	 * ����֪ͨ:������Ŀ�귽��ִ��֮ǰ��ִ��֮�������չ����
	 * @param jp ���ӵ�(Ҫִ�е�ĳ��Ŀ�귽��)
	 * @return Ŀ�귽����ִ�н��
	 * @throws Throwable
	 * ����bean(bean������)Ϊһ���������ʽ,��bean�����ҵ�񷽷�ִ��ʱ,ִ��@Aroundע�������ķ���
	 */
//	@Around("bean(sysUserServiceImpl)")
	@Around("logPointCut()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
		long t1 = System.currentTimeMillis();
		//ִ��Ŀ�귽��
		Object result = jp.proceed();
		long t2 = System.currentTimeMillis();
		System.out.println("execute time"+(t2-t1));
		//��ȡ��־��Ϣ,������д�뵽���ݿ�
		saveLog(jp,(t2-t1));
		return result;
		
	}
	private void saveLog(ProceedingJoinPoint jp, long time) throws NoSuchMethodException, SecurityException {
		//1.��ȡ��־
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		String username = user.getUsername();
		//1.2��ȡ���ʷ���(��ȫ��+"."+������)
		Object target = jp.getTarget();
		String targetClsName = target.getClass().getName();
		Signature ms = jp.getSignature();//����
		String methodName = ms.getName();
		String method = targetClsName + "."+methodName;
		//1.3��ȡ��������(ִ�з���ʱ�����ʵ�ʲ���)
		String params = Arrays.toString(jp.getArgs());
//		//1.4��ȡ��������
		//1.4.1��ȡĿ�����
//		Method targetMethod = target.getClass()
//				.getDeclaredMethod(methodName, ms.getDeclaringType());
//		System.out.println("targetMethod="+targetMethod);
//		//1.4.2��ȡĿ�귽���ϵ�RequitedLogע��
//		RequiredLog rLog = targetMethod.getDeclaredAnnotation(RequiredLog.class);
		String operation = methodName;
//		//1.4.3��ȡע���еĲ�������
//		if(rLog!=null&&StringUtils.isEmpty(rLog.value())) {
//			operation = rLog.value();
//		}
			
		//1.5��ȡIp��ַ
		String ip = IPUtils.getIpAddr();
		//2.��װ��־
		SysLog log = new SysLog();
		log.setUsername(username);
		log.setMethod(method);
		log.setParams(params);
		log.setOperation(operation);
		log.setIp(ip);
		log.setTime(time);
		log.setCreatedTime(new Date());
		//3.����־д�뵽���ݿ�
		sysLogDao.insertObject(log);
	}
	@Autowired
	private SysLogDao sysLogDao;
}
