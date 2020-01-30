package com.java.generic;
/**
 * �ӿڻ����Ͽ��Զ���������,����
 * Task�ӿڵĶ���
 * @author Administrator
 *
 * @param <Param> ���Ͳ���
 * @param <Result> ���Ͳ���
 */
interface Task<Param,Result>{
	/**
	 * �˷�������ִ������
	 * @param arg �������ɷ��Ͳ���Param����
	 * @return �������ɷ��Ͳ���result����
	 */
	Result execute(Param arg);
}

class AsyncTask implements Task<Integer,Integer>{

	@Override
	public Integer execute(Integer arg) {
		int result = 0;
		for(int i = 1; i < arg; i++) {
			if(i%2 != 0) {
				result += 1;
			}
		}
		return result;
	}
}//����ʵ�ֽӿ�

abstract class ConertTask<param,Result> implements Task<param,Result>{
	public abstract Result execute(param arg);
}

public class TestGeneric02 {
	public static void main(String[] args) {
		//��ĳ�������ڵ��������
		AsyncTask task = new AsyncTask();
		int result = task.execute(20);
		System.out.println(result);
		//=========================
		
		//����ConventTask��һ���ַ���ת��Ϊ����
		ConertTask<String,Integer> task1 = new ConertTask<String,Integer>() {
			@Override
			public Integer execute(String arg) {
				return Integer.parseInt(arg);
			}
		};
		Integer result1 = task1.execute("234345");
		System.out.println(result1);
	}
}
