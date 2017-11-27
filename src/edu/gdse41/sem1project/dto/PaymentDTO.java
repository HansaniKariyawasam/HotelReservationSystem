/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dto;

/**
 *
 * @author Hansani Kariyawasam
 */
public class PaymentDTO extends SuperDTO{
    private String paymentID;
    private String resID;
    private double paymentAmount;
    private String paymentDate;
    private String paymentMethod;
    private String gid;
    private String guestName;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentID, String paymentDate, String guestName,String resId) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.guestName = guestName;
        this.resID=resID;
    }

    public String getGid() {
        return gid;
    }
    
    public PaymentDTO(String paymentID, String resID, double paymentAmount, String paymentDate,String paymentMethod) {
        this.paymentID = paymentID;
        this.resID = resID;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod=paymentMethod;
        
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getResID() {
        return resID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    
}
