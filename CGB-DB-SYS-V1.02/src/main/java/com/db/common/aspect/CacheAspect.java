package com.db.common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.db.common.utils.LruCache;

@Service
@Aspect
public class CacheAspect {
	private LruCache<CacheKey, Object> cache = new LruCache<>(5);
	@Around("@annotation(com.db.common.annotation.RequiredCache)")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		CacheKey key = creatCacheKey(jp);
		//1.��ȡ�������,���绺��������ֱ�ӷ���
		Object obj = cache.get1(key);
		if(obj!=null)return obj;

		//3.����û������,��ֱ��Ŀ�귽��
		obj = jp.proceed();
		//4.��Ŀ�귽����ִ�н���洢���������
		cache.put1(key,obj);
		//5.���ؽ��
		return obj;
	}
	private CacheKey creatCacheKey(ProceedingJoinPoint jp) {
		Class<?> targetClass = jp.getTarget().getClass();
		MethodSignature ms = (MethodSignature) jp.getSignature();//��װ�˷���������Ϣ��ֵ����
		Method targetMethod = ms.getMethod();
		Object[] args = jp.getArgs();
		CacheKey key = new CacheKey(targetClass, targetMethod, args);
		return key;
	}
}
