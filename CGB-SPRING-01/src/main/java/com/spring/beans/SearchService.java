package com.spring.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Lazy(true)
//@Scope("singleton")//Ĭ�ϵ��� spring���𴴽�,Ҳ����������
@Scope("prototypr")//���� ÿ�λ�ȡbean���󶼻ᴴ���µ�,��spring�������
public class SearchService {
	public SearchService(){
		System.out.println("SearchService()");
	}
}
