package com.test;

public class TestArray01 {
	public static void main(String[] args) {
		//js数组定义
		//var array = []
		//var array = new Array();
		//java数组
		int[] a0 = null;
		int[] a1 = {};
		System.out.println(a0);
		System.out.println(a1);
		int[] a2 = new int[100];
		a2[0] = 10;
		a2[1] = 20;
		System.out.println(a2.length);
	}
}
