package com.ncepu.bigdata.entity;

import java.sql.Time;
import java.util.Date;

public class Comment {
    private int commentID;
    private int userID;
    private int bookID;
    private String content;
    private Date date;
    private Time time;

    public Comment() {
        this.commentID = 0;
        this.userID = 0;
        this.bookID = 0;
        this.content = null;
        this.date = null;
        this.time = null;
    }

    public Comment(int commentID, int userID, int bookID, String content, Date date, Time time) {
        this.commentID = commentID;
        this.userID = userID;
        this.bookID = bookID;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
