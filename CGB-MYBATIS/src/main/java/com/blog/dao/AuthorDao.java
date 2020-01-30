package com.blog.dao;

import java.util.Map;

import com.blog.pojo.Author;

public interface AuthorDao {
	
	Map<String,Object> findAuthor(Integer id) ;
	Author selectAuthor(Integer id);
}
