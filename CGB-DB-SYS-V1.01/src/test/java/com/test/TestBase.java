package com.test;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	protected ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	
	@Test
	public void testProperties() {
		Properties pro = ctx.getBean("cfg",Properties.class);
		System.out.println(pro);
	}
	
	@After
	public void destory() {
		ctx.close();
	}
}
