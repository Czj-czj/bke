package com.ncepu.bigdata.entity;

public class Favourite {
    private int favoriteID;
    private int userID;
    private int bookID;

    public Favourite() {
        this.favoriteID = 0;
        this.userID = 0;
        this.bookID = 0;
    }

    public Favourite(int favoriteID, int userID, int bookID) {
        this.favoriteID = favoriteID;
        this.userID = userID;
        this.bookID = bookID;
    }

    public int getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(int favoriteID) {
        this.favoriteID = favoriteID;
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
}
