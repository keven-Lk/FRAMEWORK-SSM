package com.java.modal.proxy;

/**
 * 通过继承实现拓展
 *1)优势:可读性好
 *2)劣势:
 *	a)耦合性高(子类与父类之间的耦合)
 *	b)代码量或工作量比较大
 *	c)父类一旦是final则不允许继承
 *	
 * @author Administrator
 *
 */
public class DefaultSearchServiceImpl extends SearchServiceImpl {
	@Override
	public Object search(String key) {
		long t1 = System.nanoTime();
		Object result = super.search(key);
		long t2 = System.nanoTime();
		long t =t1 - t2;
		System.out.println("total time"+t);
		return result;
	}
}
