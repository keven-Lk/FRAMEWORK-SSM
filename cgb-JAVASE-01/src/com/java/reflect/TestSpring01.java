package com.java.reflect;

import java.util.Date;
/**
 * ClassPathXmlApplicationContext ʵ�ֵĹ���
 * 1)��·����ȡ�����ļ�beans.xml,��ȡ������
 * 2)����������(��ȡxml�ļ��е�����)
 * 3)��xml�ļ��е�bean��Ϣ��װBeanDefinition����,���bean,�ٽ�BeanDefinition��װ��map
 * 4)����xml���ù�������ʵ��,���洢��instanceMap��
 * 5)����getBean����,�����ṩ����ʵ���ķ�ʽ
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
