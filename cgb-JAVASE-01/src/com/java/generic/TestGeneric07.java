package com.java.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Hello{
	int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

public class TestGeneric07 {
	public static void main(String[] args) throws Exception {
		//泛型是编译时的一种类型,运行时无效
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(100);
		//运用反射将100添加到list中
		//1.获取反射应用的起点对象
		Class<?> cls = list.getClass();
		//2.基于类对象获取add方法对象
		Method method = cls.getDeclaredMethod("add", //方法名
				Object.class);//参数类型
		//3.执行list集合的add方法
		method.invoke(list, 100);
		
		System.out.println(list);
	}
}
