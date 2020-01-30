package com.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class TestJson01 {
	@Test
	public void toJson00() {
		String s1 = "{\"id\":1,\"name\":\"admin\"}";
		System.out.println(s1);
	}
	@Test
	public void toJson01() throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("id",1001);
		map.put("name","xiaowei");
		//��mapת��Ϊjson��ʽ���ַ���
		ObjectMapper oMapper = new ObjectMapper();
		String s =oMapper.writeValueAsString(map);
		System.out.println(s);
		//��json��ʽ���ַ���ת��Ϊmap����
		map = oMapper.readValue(s.getBytes(),Map.class);
		System.out.println(s);
		
	}
}
