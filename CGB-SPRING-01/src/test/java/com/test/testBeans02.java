package com.test;

import org.junit.Test;

import com.spring.beans.SearchService;

public class testBeans02 extends TestAnnotationBase{
	@Test
	public void testGetBean() {
		//加入是延迟加载getBean时会创建对象
		SearchService service = ctx.getBean("searchService",SearchService.class);
		System.out.println(service);
	}
}
