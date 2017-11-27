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
public class GuestDTO extends SuperDTO{
    private String guestID;
    private String fName;
    private String lName;
    private String nationality;
    private String dob;
    private String passport;
    private String nic;
    private String tel;
    private String agent;
    
    private ReservationDTO reservation;
    private ArrayList<ReservationDetailsDTO> resDetails;
    
    
    public GuestDTO(){}
    public GuestDTO(String guestID,String fName,String lName,String dob,String nationality,String nic,String passport,String tel){
        this.guestID=guestID;
        this.fName=fName;
        this.lName=lName;
        this.nationality=nationality;
        this.dob=dob;
        this.passport=passport;
        this.nic=nic;
        this.tel=tel;
 
    }

    public GuestDTO(String guestID,String agent, String fName, String lName,String dob, String nationality,String nic,  String passport,  String tel ) {
        this.guestID = guestID;
        this.fName = fName;
        this.lName = lName;
        this.nationality = nationality;
        this.dob = dob;
        this.passport = passport;
        this.nic = nic;
        this.tel = tel;
        this.agent = agent;
    }

    public GuestDTO(String guestID, String fName, String lName, String nationality, String dob, String passport, String nic, String tel, ReservationDTO reservation, ArrayList<ReservationDetailsDTO> resDetails) {
        this.guestID = guestID;
        this.fName = fName;
        this.lName = lName;
        this.nationality = nationality;
        this.dob = dob;
        this.passport = passport;
        this.nic = nic;
        this.tel = tel;
        this.reservation = reservation;
        this.resDetails = resDetails;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }

    public ArrayList<ReservationDetailsDTO> getResDetails() {
        return resDetails;
    }

    public void setResDetails(ArrayList<ReservationDetailsDTO> resDetails) {
        this.resDetails = resDetails;
    }
    
    

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
    
    public void setGuestId(String guestID){
        this.guestID=guestID;
    }
    public String getGuestID(){
        return guestID;
    }
    public void setFName(String fName){
        this.fName=fName;
    }
    public String getFName(){
        return fName;
    }
    public void setLName(String lName){
        this.lName=lName;
    }
    public String getLName(){
        return lName;
    }
    public void setNationality(String nationality){
        this.nationality=nationality;
    }
    public String getNationality(){
        return nationality;
    }
    public void setDOB(String dob){
        this.dob=dob;
    }
    public String getDOB(){
        return dob;
    }
    public void setPassport(String passport){
        this.passport=passport;
    }
    public String getPassport(){
        return passport;
    }
    public void setNIC(String nic){
        this.nic=nic;
    }
    public String getNIC(){
        return nic;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public String getTel(){
        return tel;
    }
   
}
