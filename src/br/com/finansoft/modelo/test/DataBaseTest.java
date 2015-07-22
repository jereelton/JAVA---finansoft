/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finansoft.modelo.test;

import br.com.finansoft.modelo.DataBaseHandle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Fernando
 */
public class DataBaseTest {
    private static String url    = "jdbc:postgresql://localhost:5432/finansoft";
    private static String user   = "postgres";
    private static String passwd = "postgres";
    
    public static void main(String[] args) {
        DataBaseHandle dataBaseHandle = new DataBaseHandle(url, user, passwd);
        dataBaseHandle.getConnection();
        
        try {
            if(dataBaseHandle.isConnected())
                System.out.println("Connected sucessfully.");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
