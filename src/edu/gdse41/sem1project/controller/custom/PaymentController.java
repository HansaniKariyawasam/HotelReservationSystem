/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom;

import edu.gdse41.sem1project.controller.SuperController;
import edu.gdse41.sem1project.dto.PaymentDTO;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface PaymentController extends SuperController<PaymentDTO>{
    public ArrayList<Object []> paymentDetails(String id)throws Exception;
    
    public PaymentDTO searchPaymentDetails(String id)throws Exception;
}
