/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finansoft.modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class DataBaseHandle {
    private String url    = "";
    private String user   = "";
    private String passwd = "";
    private Connection connection = null;
    
    public DataBaseHandle(String url, String user, String passwd) {
        this.url    = url;
        this.user   = user;
        this.passwd = passwd;
    }
    
    public void getConnection() {
        try {
            System.out.println("Url." + this.url + " User." + this.user + " Passwd." + passwd);
            connection = DriverManager.getConnection(this.url, this.user, this.passwd);
            if(connection != null)
                System.out.println("Connection realized successfully.");
        } catch (SQLException ex) {
            System.out.println("Unable to open a connection with DB");
        }
    }
    
    public void runStatement(String sqlStatement) throws SQLException {
        Statement statement = connection.createStatement();
    
        statement.execute(sqlStatement);
    }
    
   /* public boolean isConnected() throws SQLException {
        if(! connection.isClosed()) 
            return true;
        
        return false;
    }
    */
    public boolean closeConnection() {
        boolean isClosedSuccessfully = false;
        
        try {
            connection.close();
            isClosedSuccessfully = true;
        } catch (SQLException ex) {
            System.out.println("Unable to close the connection with data base.");
        }
        
        return isClosedSuccessfully;
    }
}
