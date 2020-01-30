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
 * 切面:一个封装了拓展业务的对象
 * 切面构成分析:
 * 1)切入点(在哪些方法执行时织入拓展业务)
 * 1.1)bean()
 * 1.2)@annotion
 * 1.3)...
 * 2)通知(拓展业务中的几个步骤)
 * 2.1)@Before
 * 2.2)@After
 * 2.3)@AfterReturning
 * 2.4)@AfterThrowing
 * 2.5)@Around
 * 3)连接点(指向一个目标方法对象)
 * 3.1)JointPoint(非环绕通知中使用的连接点)
 * 3.2)ProceedingJoinPoint(环绕通知中使用)
 * 
 * @author Administrator
 */
@Order(2)//	切面执行顺序
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
	/**核心业务正常结束时执行
	 * 说明：假如有after，先执行after,再执行returning*/
	@AfterReturning("doTime()")
	public void doAfterReturning(){
		System.out.println("time doAfterReturning");
	}
	/**核心业务出现异常时执行
                 说明：假如有after，先执行after,再执行Throwing*/
	@AfterThrowing("doTime()")
	public void doAfterThrowing(){
		System.out.println("time doAfterThrowing");
	}
	/**
	 * 环绕通知
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

