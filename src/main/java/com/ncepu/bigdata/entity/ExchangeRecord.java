package com.ncepu.bigdata.entity;

import java.sql.Date;
import java.sql.Time;

public class ExchangeRecord {
    private int exchangeRecordID;
    private int senderID;
    private int receiverID;
    private int bookID;
    private String status;
    private Date date;
    private Time time;
    private String place;
    private String message;

    public ExchangeRecord() {
        this.exchangeRecordID = 0;
        this.senderID = 0;
        this.receiverID = 0;
        this.bookID = 0;
        this.status = "Pending";
        this.date = null;
        this.time = null;
        this.place = null;
        this.message = null;
    }

    public ExchangeRecord(int exchangeRecordID, int senderID, int receiverID, int bookID, String status,
                          Date date, Time time, String place, String message) {
        this.exchangeRecordID = exchangeRecordID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.bookID = bookID;
        this.status = status;
        this.date = date;
        this.time = time;
        this.place = place;
        this.message = message;
    }

    public int getExchangeRecordID() {
        return exchangeRecordID;
    }

    public void setExchangeRecordID(int exchangeRecordID) {
        this.exchangeRecordID = exchangeRecordID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
