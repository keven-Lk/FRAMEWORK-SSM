package com.java.annotation;

import java.util.HashMap;
import java.util.Map;

public class AnnotationBeanFactory {
	private static Map<String,Object> map = new HashMap<String, Object>();
	//�˷���Ϊĳ����(��@Service����)�������ʵ������
	public static void newInstance(Class<?> cls) throws Exception{
		//�ж�SysLogService�����Ƿ���Serviceע��
		boolean flag = cls.isAnnotationPresent(Service.class);
		if(!flag) return;
		//������Serviceע�����ȡע��������
		Service service = cls.getDeclaredAnnotation(Service.class);
		String key = service.value();
		//System.out.println(key);
		//����class�������ʵ��,����ʵ���洢��map
		Object instance = cls.newInstance();
		map.put(key, instance);
	}
	//���ڴ˷�����map��ȡĳ�����ʵ��
	@SuppressWarnings("unchecked")
	public static <T>T getBean(String id,Class<T> T){
		return (T)map.get(id);
	}
}
