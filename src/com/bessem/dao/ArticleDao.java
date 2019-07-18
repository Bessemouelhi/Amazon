package com.bessem.dao;

import java.util.List;

import com.bessem.beans.Article;
import com.bessem.beans.BeanException;

public interface ArticleDao {
	
	void add(Article article) throws DaoException;
	
	Article getByRef(String ref) throws BeanException, DaoException;

	void update(Article article) throws DaoException;
	
	void delete(String ref);
	
	List<Article> getAll() throws DaoException;

}
