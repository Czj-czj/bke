package com.ncepu.bigdata.entity;

import java.sql.Date;
import java.sql.Time;

public class Message {
    private int messageId;
    private int userId;
    private int receiverId;
    private String content;
    private Date date;
    private Time time;

    public Message(int messageId, int userId, int receiverId, String content, Date date, Time time) {
        this.messageId = messageId;
        this.userId = userId;
        this.receiverId = receiverId;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
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
