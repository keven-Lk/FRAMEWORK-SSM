package com.test;

public class TestThread01 {
	public static void main(String[] args) throws InterruptedException {
		//1.�����̶߳���
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("run");
			}
		};
		//2.���̸߳������������߳�
		t1.start();//����״̬(������״̬)
		//t1.join(); �˷�������t1��ϲŻ�ִ������
		System.out.println("main");
	}
}
