/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hansani Kariyawasam
 */
public class LoginController {
    
//    private static Connection con;
//
//    {
//        con=ConnectionFactory.getInstance().getConnection();
//        System.out.println(con.toString());
//    }
    
    
    
    public static UsersDTO Login(String username,String password) throws SQLException, ClassNotFoundException{
        String sql="SELECT * FROM users WHERE username=?";
        Connection con=ConnectionFactory.getInstance().getConnection();
        System.out.println(con.toString());
        PreparedStatement stm=con.prepareStatement(sql);
        stm.setObject(1, username);
        ResultSet rst=stm.executeQuery();
        UsersDTO user=null;
        if(rst.next()){
            String pswd=rst.getString(2);
            if(pswd.equals(password)){
                user=new UsersDTO(rst.getString(1),rst.getString(2),rst.getString(3));
                return user;
            }
        }
        return user;
    }
}
