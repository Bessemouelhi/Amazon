package com.bessem.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bessem.beans.Article;
import com.bessem.dao.ArticleDao;
import com.bessem.dao.DaoException;
import com.bessem.dao.DaoFactory;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao;
	List<Article> articles;
	boolean isSort = false;
       
    
    public AccueilServlet() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        articleDao = daoFactory.getArticleDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			articles = articleDao.getAll();
			
			// Tri du tableau par colonne (reference, designation ou prix)
			String getSort = request.getParameter("sort");
			if (getSort != null) {
				if (getSort.equals("ref")) {
					if (isSort) {
						Collections.sort(articles, Article.compareByRef);
					}
					else {
						Collections.sort(articles, Article.compareByRef.reversed());
					}
				}
				else if (getSort.equals("des")) {
					if (isSort) {
						Collections.sort(articles, Article.compareByDes);
					}
					else {
						Collections.sort(articles, Article.compareByDes.reversed());
					}
				}
				else if (getSort.equals("prix")) {
					if (isSort) {
						Collections.sort(articles, Article.compareByPrix);
					}
					else {
						Collections.sort(articles, Article.compareByPrix.reversed());
					}
				}
				isSort = !isSort;
			}
			
			// Envoie de la list d'articles à la vue
			request.setAttribute("articles", articles);
		} catch (DaoException e) {
			request.setAttribute("exception", e.getMessage());
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		String des = request.getParameter("des");
		
		String message = "Vous avez recherché l'article suivant : ";

		request.setAttribute("message", message);
		request.setAttribute("ref", ref);
		request.setAttribute("des", des);
		
		try {
			articles = articleDao.getAll();
			// Envoie de la list d'articles à la vue
			request.setAttribute("articles", articles);
		} catch (DaoException e) {
			request.setAttribute("exception", e.getMessage());
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
