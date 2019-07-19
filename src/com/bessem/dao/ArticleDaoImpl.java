package com.bessem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bessem.beans.Article;
import com.bessem.beans.BeanException;

public class ArticleDaoImpl implements ArticleDao {
	
	private DaoFactory daoFactory;

	ArticleDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void add(Article article) throws DaoException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            
            preparedStatement = connexion.prepareStatement("INSERT INTO article(reference, designation, prix) VALUES(?, ?, ?);");
            preparedStatement.setString(1, article.getReference());
            preparedStatement.setString(2, article.getDesignation());
            preparedStatement.setDouble(3, article.getDecimal());

            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
		
	}

	@Override
	public Article getByRef(String ref) throws BeanException, DaoException {
		Article article = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT reference, designation, prix FROM article WHERE reference = ?;");
            statement.setString(1, ref);
            resultat = statement.executeQuery();
            
            while (resultat.next()) {
                String refe = resultat.getString("reference");
                String des = resultat.getString("designation");
                double prix = resultat.getDouble("prix");

                article = new Article();
                article.setReference(refe);
                article.setDesignation(des);
                article.setDecimal(prix);
            }
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        
        return article;
	}

	@Override
	public List<Article> getAll() throws DaoException {
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
            throw new DaoException("Impossible de communiquer avec la base de données");
        } catch (BeanException e) {
            throw new DaoException("Les données de la base sont invalides");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return listArticle;
	}

	@Override
	public void update(Article article) throws DaoException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            
            preparedStatement = connexion.prepareStatement("UPDATE article" + 
            		" SET designation = ?," + 
            		" prix = ?" + 
            		" WHERE reference = ?");
            preparedStatement.setString(1, article.getDesignation());
            preparedStatement.setDouble(2, article.getDecimal());
            preparedStatement.setString(3, article.getReference());

            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
		
	}

	@Override
	public void delete(String ref) throws DaoException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            
            preparedStatement = connexion.prepareStatement("DELETE FROM article" + 
            		" WHERE reference = ?");
            preparedStatement.setString(1, ref);

            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLIntegrityConstraintViolationException e) {
        	throw new DaoException("Impossible de supprimer ou de mettre à jour cet article");
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException(e.toString());
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données 2");
            }
        }
		
	}

}
