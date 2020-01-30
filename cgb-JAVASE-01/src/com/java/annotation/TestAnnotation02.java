package com.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Service{
	String value() default "";
}

@Service(value = "logService")
class SysLogService{}

class SysUserService{}

public class TestAnnotation02 {
	//存储bean
	private static Map<String,Object> map = new HashMap<String, Object>();
	public static void main(String[] args) throws Exception {
		//如何检测SysLogService类上是否有@Service注解
		AnnotationBeanFactory factory = new AnnotationBeanFactory();
		factory.newInstance(SysLogService.class);
		//基于某个方法从map容器获取类的实例
		SysLogService s1 = 
				AnnotationBeanFactory.getBean("logService", SysLogService.class);
		SysLogService s2 = 
				factory.getBean("logService", SysLogService.class);
		System.out.println(s1==s2);
	}
	


}
