package com.test.service;

public class DefaultSearchService {
	public Object search(String key) {
//		System.out.println("search start...");
		System.out.println("search result by key");
//		System.out.println("search end...");
		return "result by" +key;
	}
}
