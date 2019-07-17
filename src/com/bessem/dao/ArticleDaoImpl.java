package com.bessem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bessem.beans.Article;

public class ArticleDaoImpl implements ArticleDao {
	
	private DaoFactory daoFactory;

	ArticleDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void add(Article article) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            
            preparedStatement = connexion.prepareStatement("INSERT INTO article(reference, designation, prix) VALUES(?, ?, ?);");
            preparedStatement.setString(1, article.getReference());
            preparedStatement.setString(2, article.getDesignation());
            preparedStatement.setDouble(3, article.getDecimal());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Article getByRef(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getAll() {
		List<Article> listArticle = new ArrayList<Article>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT reference, designation, prix FROM article;");

            while (resultat.next()) {
                String ref = resultat.getString("reference");
                String des = resultat.getString("designation");
                double prix = resultat.getDouble("prix");

                Article article = new Article();
                article.setReference(ref);
                article.setDesignation(des);
                article.setDecimal(prix);

                listArticle.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listArticle;
	}

}
