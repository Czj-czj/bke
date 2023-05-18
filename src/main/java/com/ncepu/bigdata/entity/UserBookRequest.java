package com.ncepu.bigdata.entity;

public class UserBookRequest {
    private int userBookRequestId;
    private int userId;
    private int bookRequestId;

    public UserBookRequest() {
        this.userBookRequestId = 0;
        this.userId = 0;
        this.bookRequestId = 0;
    }

    public UserBookRequest(int userBookRequestId, int userId, int bookRequestId) {
        this.userBookRequestId = userBookRequestId;
        this.userId = userId;
        this.bookRequestId = bookRequestId;
    }

    public int getUserBookRequestId() {
        return userBookRequestId;
    }

    public void setUserBookRequestId(int userBookRequestId) {
        this.userBookRequestId = userBookRequestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookRequestId() {
        return bookRequestId;
    }

    public void setBookRequestId(int bookRequestId) {
        this.bookRequestId = bookRequestId;
    }

    @Override
    public String toString() {
        return "UserBookRequest{" +
                "userBookRequestId=" + userBookRequestId +
                ", userId=" + userId +
                ", bookRequestId=" + bookRequestId +
                '}';
    }
}
