package com.ncepu.bigdata.entity;

public class TagBook {
    private int tagBookID;
    private int bookID;
    private int tagID;

    public TagBook() {
        this.tagBookID = 0;
        this.bookID = 0;
        this.tagID = 0;
    }

    public TagBook(int tagBookID, int bookID, int tagID) {
        this.tagBookID = tagBookID;
        this.bookID = bookID;
        this.tagID = tagID;
    }

    public int getTagBookID() {
        return tagBookID;
    }

    public void setTagBookID(int tagBookID) {
        this.tagBookID = tagBookID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    @Override
    public String toString() {
        return "TagBook [tagBookID=" + tagBookID + ", bookID=" + bookID + ", tagID=" + tagID + "]";
    }
}
