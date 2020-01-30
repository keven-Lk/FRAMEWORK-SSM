package com.java.enums;

enum Gender{//Gender.class
	MALE,FEMALE,NONE;//枚举的三个实例
	/*private Gender() {//假如写,那么必须私有化
		System.out.println("Gender()");
	}*/
}

class Product{
	/*
	 * 性别要求
	 */
	private Gender gender = Gender.NONE;
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}

public class TestEnum01 {
	public static void main(String[] args) {
		Product pro = new Product();
		pro.setGender(Gender.MALE);
		Gender gender = Gender.NONE;
	}
}
