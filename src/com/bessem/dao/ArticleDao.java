package com.bessem.dao;

import java.util.List;

import com.bessem.beans.Article;

public interface ArticleDao {
	
	void add(Article article);
	
	Article getByRef(String ref);

	void update(Article article);
	
	void delete(String ref);
	
	List<Article> getAll();

}
