package com.java.reflect;

import java.util.Date;
/**
 * ClassPathXmlApplicationContext 实现的功能
 * 1)类路径读取配置文件beans.xml,获取流对象
 * 2)解析流对象(读取xml文件中的内容)
 * 3)将xml文件中的bean信息封装BeanDefinition对象,多个bean,再将BeanDefinition封装到map
 * 4)基于xml配置构建对象实例,并存储到instanceMap中
 * 5)定义getBean方法,对外提供访问实例的方式
 * @author Administrator
 *
 */

public class TestSpring01 {
	public static void main(String[] args) throws Exception {
	ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext("beans.xml");
	Date date = ctx.getBean("date",Date.class);
	System.out.println(date);
	}
}
