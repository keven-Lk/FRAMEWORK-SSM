package com.java.generic;
/**
 * 类泛型:只能应用于实例方法,不能应用于静态方法
 * 实例方法就是没有static修饰的方法
 * @author Administrator
 *
 */
class ClassUtil<T>{
	/*
	 * 实例方法:此方法中的泛型由类型决定
	 */
	T newInstance(Class<T> clazz){
		return null;
	}
	
	/*
	 * 泛型方法:可以是静态方法,也可以是实例方法
	 */
	public static <E>void print(E t) {}
}

public class TestGeneric04 {
	public static void main(String[] args) {
		ClassUtil<String> c1 = new ClassUtil<>();
		String o = c1.newInstance(String.class);
	}
}
