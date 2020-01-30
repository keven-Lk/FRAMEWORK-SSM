package com.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.SpringConfig;

public class TestAnnotationBase {
	protected AnnotationConfigApplicationContext ctx;
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
	}
	
	@After
	public void close() {
		ctx.close();
	}
}
