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
public class ReservationDetailsDTO extends SuperDTO{
    private String resDetailsID;
    private String guestID;
    private String roomID;
    private String resID;
    private String reservedDate;
    private double price;
    private String fname;
    private String lname;
    private String tel;

    public ReservationDetailsDTO() {
    }

    public ReservationDetailsDTO(String resDetailsID, String guestID, String roomID, String resID,String reservedDate, double price) {
        this.resDetailsID = resDetailsID;
        this.guestID = guestID;
        this.roomID = roomID;
        this.resID = resID;
        this.price = price;
        this.reservedDate=reservedDate;
    }

    public ReservationDetailsDTO(String resID,String guestID,  String reservedDate, String fname, String lname, String tel) {
        this.guestID = guestID;
        this.resID = resID;
        this.reservedDate = reservedDate;
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    

    public void setResDetailsID(String resDetailsID) {
        this.resDetailsID = resDetailsID;
    }

    public String getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(String reservedDate) {
        this.reservedDate = reservedDate;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getResDetailsID() {
        return resDetailsID;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getResID() {
        return resID;
    }

    public double getPrice() {
        return price;
    }


}
