/*
* DBDao.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Article;

/**
 * DBDao.<br>
 *
 * <pre>
 *The class uses queries to retrieve data from the database
 *In this class, we will proceed with the following processing.
 *
 * . getTop1.
 * . getPostById
 * . getTop5
 * . searchArticle
 * . countPos
 *
 *
 * </pre>
 *
 * @author Hoang Viet
 * @version 1.0
 */
public class DBDao {

    /**
     * Store db.
     */
    private final DBContext db;

    /**
     * Constructor no parameter.<br>
     */
    public DBDao() {
        this.db = new DBContext();
    }

    /**
     * getTop1.<br>
     * Retrieve the most recently posted article
     *
     * @return a article
     * @throws ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Article getTop1() throws ClassNotFoundException, SQLException {
        Statement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT top 1  [id]\n");
        sql.append(",[title]\n");
        sql.append(",[image]\n");
        sql.append(",[content]\n");
        sql.append(",[date]\n");
        sql.append(",[author]\n");
        sql.append("FROM [dbo].[Article]\n");
        sql.append("order by date desc");
        try {
            conn = db.getConnection();
            ps = conn.createStatement();
            rs = ps.executeQuery(sql.toString());
            if (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImages(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
                return article;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }

    /**
     * getPostById.<br>
     * function to get Post by id.
     *
     * @param id
     * @return a article
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Article getPostById(int id) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT [id]\n");
        sql.append(",[title]\n");
        sql.append(",[image]\n");
        sql.append(",[content]\n");
        sql.append(",[date]\n");
        sql.append(",[author]\n");
        sql.append("FROM [dbo].[Article]\n");
        sql.append("where id= ?");
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImages(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
                return article;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }

    /**
     * getTop5.<br>
     * function to get top 5 recently posted article
     *
     * @return a list article
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public List<Article> getTop5() throws ClassNotFoundException, SQLException {
        Statement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Article> articles = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT top 5  [id]\n");
        sql.append(",[title]\n");
        sql.append(",[image]\n");
        sql.append(",[content]\n");
        sql.append(",[date]\n");
        sql.append(",[author]\n");
        sql.append("FROM [dbo].[Article]\n");
        sql.append("order by date desc");
        try {
            conn = db.getConnection();
            ps = conn.createStatement();
            rs = ps.executeQuery(sql.toString());
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImages(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
                articles.add(article);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return articles;
    }

    /**
     * searchArticle.<br>
     * the function is used to search and paginate by title
     *
     * @param stringSearch
     * @param pageIndex
     * @param pageSize
     * @return a list article
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public List<Article> searchArticle(String stringSearch, int pageIndex, int pageSize) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Article> articles = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from (\n");
        sql.append("select*, ROW_NUMBER() over (order by ID ASC) as page from Article where title like ?)\n");
        sql.append("as a where  page between ?*?-2 and ?*?");
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, "%" + stringSearch + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageIndex);
            ps.setInt(5, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImages(rs.getString("image"));
                article.setContent(rs.getString("content"));
                article.setDate(rs.getDate("date"));
                article.setAuthor(rs.getString("author"));
                articles.add(article);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return articles;
    }

    /**
     * countPost.<br>
     * the function is used to count Posts
     *
     * @param stringSearch
     * @return a integer value
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public int countPost(String stringSearch) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        int count = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) as post from Article \n");
        sql.append("where title like ?");
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, "%" + stringSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return count;
    }
}
