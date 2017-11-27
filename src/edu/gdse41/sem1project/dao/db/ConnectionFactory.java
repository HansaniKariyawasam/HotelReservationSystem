/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ConnectionFactory {
    private Connection conn;
    private static ConnectionFactory dbConnection;
    private ConnectionFactory(){
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
        Properties dbPropeties=new Properties();
        File dbFile=new File("settings/dbSettings.properties");
        FileReader dbFileReader;
        try {
            dbFileReader = new FileReader(dbFile);
            dbPropeties.load(dbFileReader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url="jdbc:mysql://"
                +dbPropeties.getProperty("ip")
                +"/"+dbPropeties.getProperty("database");
        String username=dbPropeties.getProperty("username");
        String password=dbPropeties.getProperty("password");
         try {
             conn=DriverManager.getConnection(url,username,password);
         } catch (SQLException ex) {
             Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public Connection getConnection(){
        return conn;
    }
    public static ConnectionFactory getInstance(){
        if(dbConnection==null){
            dbConnection=new ConnectionFactory();
        }
        return dbConnection;
    }
}
