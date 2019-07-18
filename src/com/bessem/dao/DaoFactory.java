package com.bessem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DaoFactory {
	
	private static DaoFactory instance = null;
	
	private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
    	
    	if(instance != null) {
    		return instance;
    	}
    	
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/amazon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
    	Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion; 
    }

    // Récupération de ArticleDao
    public ArticleDao getArticleDao() {
        return new ArticleDaoImpl(this);
    }

}
