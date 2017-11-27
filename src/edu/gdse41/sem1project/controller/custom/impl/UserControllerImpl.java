/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.controller.custom.UserController;
import edu.gdse41.sem1project.dao.DAOFactory;
import edu.gdse41.sem1project.dao.custom.UserDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.UsersDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class UserControllerImpl implements UserController{
    
    private Connection conn;
    private UserDAO userDAO;

    public UserControllerImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
        userDAO=(UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    }
    
    


    @Override
    public boolean add(UsersDTO u1) throws Exception {
        return userDAO.add(u1);
    }

    @Override
    public boolean update(UsersDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsersDTO> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
