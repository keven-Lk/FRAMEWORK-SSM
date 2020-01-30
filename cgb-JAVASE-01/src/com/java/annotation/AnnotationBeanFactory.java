package com.java.annotation;

import java.util.HashMap;
import java.util.Map;

public class AnnotationBeanFactory {
	private static Map<String,Object> map = new HashMap<String, Object>();
	//此方法为某个类(有@Service修饰)创建类的实例对象
	public static void newInstance(Class<?> cls) throws Exception{
		//判定SysLogService类上是否有Service注解
		boolean flag = cls.isAnnotationPresent(Service.class);
		if(!flag) return;
		//假如有Service注解则获取注解中内容
		Service service = cls.getDeclaredAnnotation(Service.class);
		String key = service.value();
		//System.out.println(key);
		//基于class创建类的实例,并将实例存储到map
		Object instance = cls.newInstance();
		map.put(key, instance);
	}
	//基于此方法从map获取某个类的实例
	@SuppressWarnings("unchecked")
	public static <T>T getBean(String id,Class<T> T){
		return (T)map.get(id);
	}
}
