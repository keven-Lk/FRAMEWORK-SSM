package com.java.enums;

enum Gender{//Gender.class
	MALE,FEMALE,NONE;//ö�ٵ�����ʵ��
	/*private Gender() {//����д,��ô����˽�л�
		System.out.println("Gender()");
	}*/
}

class Product{
	/*
	 * �Ա�Ҫ��
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
