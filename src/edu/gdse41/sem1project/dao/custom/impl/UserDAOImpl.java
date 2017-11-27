/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.UserDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class UserDAOImpl implements UserDAO{
    
    private Connection conn;

    public UserDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    

    @Override
    public boolean add(UsersDTO u1) throws Exception {
        String sql="Insert into Users values(?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, u1.getUsername());
        stm.setObject(2, u1.getPassword());
        stm.setObject(3, u1.getPrivilege());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(UsersDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsersDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
