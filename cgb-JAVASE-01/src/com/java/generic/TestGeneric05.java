package com.java.generic;
class Log{}
/**
 * ����ͨ���"?"��Ӧ��
 * ˵��:"?"����һ�ֲ�ȷ������,
 * ��ʹ��һ��������ʱ���������Ͳ�ȷ������ʹ��"?"����
 * @author Administrator
 *
 */
public class TestGeneric05 {
	public static void main(String[] args) throws Exception {
		Class<Log> c1 = Log.class;//�����
		//System.out.println(c1);
		//"?"Ϊ���͵�һ��ͳ���
		//������Ӧ��ʱ,�޷��ж���������ʱ,ʹ��"?"���
		//Class<Log> c2 = (Class<Log>)Class.forName("com.java.generic.Log");
		Class<?> c2 = Class.forName("com.java.generic.Log");
		System.out.println(c1==c2);
	}
}
