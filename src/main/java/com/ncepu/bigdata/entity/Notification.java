package com.ncepu.bigdata.entity;

import java.sql.Time;
import java.util.Date;

public class Notification {
    private int notificationID;
    private int userID;
    private String content;
    private Date date;
    private Time time;
    private boolean isRead;

    public Notification() {
        this.notificationID = 0;
        this.userID = 0;
        this.content = "";
        this.date = null;
        this.time = null;
        this.isRead = false;
    }

    public Notification(int notificationID, int userID, String content, Date date, Time time, boolean isRead) {
        this.notificationID = notificationID;
        this.userID = userID;
        this.content = content;
        this.date = date;
        this.time = time;
        this.isRead = isRead;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationID=" + notificationID +
                ", userID=" + userID +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", isRead=" + isRead +
                '}';
    }
}
