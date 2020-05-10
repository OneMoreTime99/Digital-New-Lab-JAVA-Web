/*
* DBContext.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
*/
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBContext.<br>
 * 
 * <pre>
 * Class connect to  sqlServer
 * In this class, we will proceed with the following processing
 
 * . constructor.
  
 </pre>
 * 
 * @author Hoang Viet
 * @version1.0
 */
public class DBContext {
    /**
     * getConnection <br>
     * 
     * Connect to SQLServer
     * If has error then throw exception.
     * 
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    private final String serverName = "localhost";
    private final String dbName = "digital_HoangViet";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456789";
    
     /**
     * Method is used to close connection with PrepareStatement
     * 
     * @param ps
     * @param con
     * @param rs
     * @throws java.sql.SQLException
     */
     public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
     /**
     * Method is used to close connection with Statement
     * 
     * @param ps
     * @param con
     * @param rs
     * @throws java.sql.SQLException
     */
     public void closeConnection(ResultSet rs, Statement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
