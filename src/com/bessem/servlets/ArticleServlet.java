package com.bessem.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		String des = request.getParameter("des");
		String prix = request.getParameter("prix");
		
		String message = "Vous avez ajouter l'article suivant : ";

		request.setAttribute("message", message);
		request.setAttribute("ref", ref);
		request.setAttribute("des", des);
		request.setAttribute("prix", prix);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

}
