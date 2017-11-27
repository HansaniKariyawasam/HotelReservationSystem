/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.controller.custom.PaymentController;
import edu.gdse41.sem1project.dao.DAOFactory;
import edu.gdse41.sem1project.dao.custom.PaymentDAO;
import edu.gdse41.sem1project.dao.custom.QueryDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.PaymentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class PaymentControllerImpl implements PaymentController{
    
    private Connection conn;
    private PaymentDAO paymentDAO;
    private QueryDAO queryDAO;

    public PaymentControllerImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
        paymentDAO=(PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        queryDAO=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }
    
    @Override
    public PaymentDTO searchPaymentDetails(String id) throws Exception {
        return queryDAO.searchPaymentDetails(id);
    }
    
    @Override
    public ArrayList<Object[]> paymentDetails(String id) throws Exception {
        return queryDAO.viewPaymentDetails(id);
    }

    @Override
    public boolean add(PaymentDTO p1) throws Exception {
        return paymentDAO.add(p1);
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        return paymentDAO.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaymentDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaymentDTO> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
