/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dto;

import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ReservationDTO extends SuperDTO{
    private String resID;
    private String checkInDate;
    private String checkOutDate;
    private String agent;
    
    private ArrayList<ReservationDetailsDTO> resDetails;
    private PaymentDTO payment;
    
    public ReservationDTO(){}
    
    public ReservationDTO(String resID,String checkInDate,String checkOutDate,String agent){
        this.resID=resID;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.agent=agent;
    }

    public ReservationDTO(String resID, String checkInDate, String checkOutDate, String agent, ArrayList<ReservationDetailsDTO> resDetails, PaymentDTO payment) {
        this.resID = resID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.agent = agent;
        this.resDetails = resDetails;
        this.payment = payment;
    }

    public ArrayList<ReservationDetailsDTO> getResDetails() {
        return resDetails;
    }

    public void setResDetails(ArrayList<ReservationDetailsDTO> resDetails) {
        this.resDetails = resDetails;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }
    
    

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
    
    public void setResID(String resID){
        this.resID=resID;
    }
    public String getResID(){
        return resID;
    }
    public void setCheckInDate(String checkInDate){
        this.checkInDate=checkInDate;
    }
    public String getCheckInDate(){
        return checkInDate;
    }
    public void setCheckOutDate(String checkOutDate){
        this.checkOutDate=checkOutDate;
    }
    public String getCheckOutDate(){
        return checkOutDate;
    }
}
