package com.test;

public class TestThread01 {
	public static void main(String[] args) throws InterruptedException {
		//1.创建线程对象
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("run");
			}
		};
		//2.主线程负责启动工作线程
		t1.start();//就绪状态(可运行状态)
		//t1.join(); 此方法表面t1完毕才会执行下列
		System.out.println("main");
	}
}
