package com.db.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
/**
 * ����:һ����װ����չҵ��Ķ���
 * ���湹�ɷ���:
 * 1)�����(����Щ����ִ��ʱ֯����չҵ��)
 * 1.1)bean()
 * 1.2)@annotion
 * 1.3)...
 * 2)֪ͨ(��չҵ���еļ�������)
 * 2.1)@Before
 * 2.2)@After
 * 2.3)@AfterReturning
 * 2.4)@AfterThrowing
 * 2.5)@Around
 * 3)���ӵ�(ָ��һ��Ŀ�귽������)
 * 3.1)JointPoint(�ǻ���֪ͨ��ʹ�õ����ӵ�)
 * 3.2)ProceedingJoinPoint(����֪ͨ��ʹ��)
 * 
 * @author Administrator
 */
@Order(2)//	����ִ��˳��
@Service
@Aspect
public class DemoAspect {
	@Pointcut("bean(sysUserServiceImpl)")
	public void doTime(){}

	@Before("doTime()")
	public void doBefore(JoinPoint jp){
		System.out.println("time doBefore()");
	}
	@After("doTime()")
	public void doAfter(){
		System.out.println("time doAfter()");
	}
	/**����ҵ����������ʱִ��
	 * ˵����������after����ִ��after,��ִ��returning*/
	@AfterReturning("doTime()")
	public void doAfterReturning(){
		System.out.println("time doAfterReturning");
	}
	/**����ҵ������쳣ʱִ��
                 ˵����������after����ִ��after,��ִ��Throwing*/
	@AfterThrowing("doTime()")
	public void doAfterThrowing(){
		System.out.println("time doAfterThrowing");
	}
	/**
	 * ����֪ͨ
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
	@Around("doTime()")
	public Object doAround(ProceedingJoinPoint jp)
			throws Throwable{
		System.out.println("doAround.before");
		Object obj=jp.proceed();
		System.out.println("doAround.after");
		return obj;
	}
}

