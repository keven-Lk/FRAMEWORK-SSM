package com.java.memory;

class Activity{
	static class WorkThread extends Thread{
		@Override
		public void run() {
			while(true) {}
		}
	}
	
	public void OnCreate() {
		new WorkThread().start();
	}
	 
	@Override
	protected void finalize() throws Throwable {
		System.out.println("==finalize()==");
	}
}

public class TestMemory02 {
	public static void main(String[] args) {
		Activity aty = new Activity();
		aty.OnCreate();
		aty = null;
		//�����󲻿ɷ���,����ռ�����ڴ�,���������֮Ϊ�ڴ�й©
		System.gc();//����GC
	}
}
