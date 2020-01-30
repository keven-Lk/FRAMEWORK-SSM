package com.java.generic;
/**
 * 接口或类上可以定义多个泛型,例如
 * Task接口的定义
 * @author Administrator
 *
 * @param <Param> 泛型参数
 * @param <Result> 泛型参数
 */
interface Task<Param,Result>{
	/**
	 * 此方法用于执行任务
	 * @param arg 其类型由泛型参数Param决定
	 * @return 其类型由泛型参数result决定
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
}//让类实现接口

abstract class ConertTask<param,Result> implements Task<param,Result>{
	public abstract Result execute(param arg);
}

public class TestGeneric02 {
	public static void main(String[] args) {
		//将某整数以内的奇数求和
		AsyncTask task = new AsyncTask();
		int result = task.execute(20);
		System.out.println(result);
		//=========================
		
		//借助ConventTask将一个字符串转换为整数
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
