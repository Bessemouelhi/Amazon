package com.bessem.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bessem.beans.Article;
import com.bessem.dao.ArticleDao;
import com.bessem.dao.DaoFactory;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao;

	public ArticleServlet() {
		super();
		DaoFactory daoFactory = DaoFactory.getInstance();
		articleDao = daoFactory.getArticleDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// R�cuperation de liste d'article pour affichage
		request.setAttribute("articles", articleDao.getAll());

		String getRef = request.getParameter("ref");
		if (getRef != null) {
			request.setAttribute("getRef", getRef);
			request.setAttribute("art", articleDao.getByRef(getRef));
		}
		
		String submitType = request.getParameter("submitType");
		request.setAttribute("submitType", submitType);

		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Recuperation du type de bouton (Ajouter ou Modifier)
		String submitType = request.getParameter("submitType");
		request.setAttribute("submitType", submitType);

		// R�cuperation des champs depuis le formulaire
		String ref = request.getParameter("ref");
		String des = request.getParameter("des");
		double prix = 0;
		if (!request.getParameter("prix").equals(""))
			prix = Double.parseDouble(request.getParameter("prix"));

		if (ref != null && des != null && prix > 0) {
			// Cr�ation d'un objet Article
			Article article = new Article();
			article.setReference(ref);
			article.setDesignation(des);
			article.setDecimal(prix);

			String message = "Vous avez ajouter l'article suivant : ";

			request.setAttribute("message", message);
			request.setAttribute("ref", ref);
			request.setAttribute("des", des);
			request.setAttribute("prix", prix);
			
			if(submitType.equals("Ajouter")) {
				articleDao.add(article); // Ajout d'un article dans la bdd
			}
			else {
				articleDao.update(article); // Modif d'un article dans la bdd
			}

		}
		
		

		// R�cuperation de la liste d'article pour affichage
		request.setAttribute("articles", articleDao.getAll());

		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

}
