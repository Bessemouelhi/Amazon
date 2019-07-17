package com.bessem.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bessem.dao.ArticleDao;
import com.bessem.dao.DaoFactory;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao;
       
    
    public AccueilServlet() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        articleDao = daoFactory.getArticleDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("articles", articleDao.getAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		String des = request.getParameter("des");
		
		String message = "Vous avez recherché l'article suivant : ";

		request.setAttribute("message", message);
		request.setAttribute("ref", ref);
		request.setAttribute("des", des);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
