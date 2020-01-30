package com.test;

import org.junit.Test;

import com.spring.beans.ConnectionPool;
import com.spring.beans.SearchService;

public class TsetBeans01 extends TestXMLBase{
	@Test
	public void testGetBean01() {
		ConnectionPool cPool = ctx.getBean("cPool",ConnectionPool.class);
		System.out.println(cPool);
	}
	
	@Test
	public void testGetBean02() {
		SearchService searchService =
				ctx.getBean("searchService",SearchService.class);
		System.out.println(searchService);
	}
}
