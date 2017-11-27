/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.PaymentDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.PaymentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class PaymentDAOImpl implements PaymentDAO{
    
    private Connection conn;
    

    public PaymentDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    

    @Override
    public boolean add(PaymentDTO p1) throws Exception {
        String sql="Insert into Payment values(?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, p1.getPaymentID());
        stm.setObject(2, p1.getResID());
        stm.setObject(3, p1.getPaymentAmount());
        stm.setObject(4, p1.getPaymentDate());
        stm.setObject(5, p1.getPaymentMethod());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        String sql="UPDATE payment SET amountPaid =amountPaid+?, paymentDate =? WHERE pid = ?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getPaymentAmount());
        stm.setObject(2, dto.getPaymentDate());
        stm.setObject(3, dto.getPaymentID());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaymentDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaymentDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
