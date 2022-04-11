/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tharindu
 */
public class DbUtil {
    
    private static final String DRIVER_CLASS = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/num_quiz";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "test";
    private static Connection dbConnection = null;
    
    
    private DbUtil(){}
    
    public static synchronized Connection getDBConnection() {
        if(dbConnection == null) {
            try {
                Class.forName(DRIVER_CLASS);
                if (dbConnection == null) dbConnection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            } catch(SQLException | ClassNotFoundException ex){
                ex.printStackTrace();
            }
            
        }
        
        return dbConnection;
    }
    
    
    
}
