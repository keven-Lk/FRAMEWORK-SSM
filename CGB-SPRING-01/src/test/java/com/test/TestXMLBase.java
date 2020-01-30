package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXMLBase {
	protected ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	}
	
	@Test
	public void testCtx() {
		System.out.println(ctx);
	}
	
	@After
	public void close() {
		ctx.close();
	}
}
