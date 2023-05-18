package com.ncepu.bigdata.entity;

public class BookExchangeRecord {
    private int bookExchangeRecordID;
    private int bookID;
    private int exchangeRecordID;

    public BookExchangeRecord() {
        this.bookExchangeRecordID = 0;
        this.bookID = 0;
        this.exchangeRecordID = 0;
    }

    public BookExchangeRecord(int bookExchangeRecordID, int bookID, int exchangeRecordID) {
        this.bookExchangeRecordID = bookExchangeRecordID;
        this.bookID = bookID;
        this.exchangeRecordID = exchangeRecordID;
    }

    public int getBookExchangeRecordID() {
        return bookExchangeRecordID;
    }

    public void setBookExchangeRecordID(int bookExchangeRecordID) {
        this.bookExchangeRecordID = bookExchangeRecordID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getExchangeRecordID() {
        return exchangeRecordID;
    }

    public void setExchangeRecordID(int exchangeRecordID) {
        this.exchangeRecordID = exchangeRecordID;
    }
}
