package com.spring.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Lazy(true)
//@Scope("singleton")//默认单例 spring负责创建,也负责管理对象
@Scope("prototypr")//多例 每次获取bean对象都会创建新的,但spring不会管理
public class SearchService {
	public SearchService(){
		System.out.println("SearchService()");
	}
}
