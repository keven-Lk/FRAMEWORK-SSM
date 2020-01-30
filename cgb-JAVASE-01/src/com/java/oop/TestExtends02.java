package com.java.oop;

import java.util.List;
import java.util.Map;

interface SearchService{
	Object search(String key);
	List<Map<String,Object>> find(String key);
}
abstract class AbsSearchService implements SearchService{
	@Override
	public Object search(String key) {
		return null;
	}
}

public class TestExtends02 {

}
