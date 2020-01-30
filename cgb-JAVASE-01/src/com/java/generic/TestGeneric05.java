package com.java.generic;
class Log{}
/**
 * 泛型通配符"?"的应用
 * 说明:"?"代表一种不确定类型,
 * 当使用一个泛型类时假如其类型不确定可以使用"?"代替
 * @author Administrator
 *
 */
public class TestGeneric05 {
	public static void main(String[] args) throws Exception {
		Class<Log> c1 = Log.class;//类对象
		//System.out.println(c1);
		//"?"为泛型的一个统配符
		//当泛型应用时,无法判定具体类型时,使用"?"替代
		//Class<Log> c2 = (Class<Log>)Class.forName("com.java.generic.Log");
		Class<?> c2 = Class.forName("com.java.generic.Log");
		System.out.println(c1==c2);
	}
}
