package com.test;

import org.junit.Test;

import com.spring.beans.SearchService;

public class testBeans02 extends TestAnnotationBase{
	@Test
	public void testGetBean() {
		//�������ӳټ���getBeanʱ�ᴴ������
		SearchService service = ctx.getBean("searchService",SearchService.class);
		System.out.println(service);
	}
}
