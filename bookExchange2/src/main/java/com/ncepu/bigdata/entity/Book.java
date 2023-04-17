package com.ncepu.bigdata.entity;

public class Book {
    private int bookID;
    private int userID;
    private String title;
    private String author;
    private String publisher;
    private String publishDate;
    private String description;
    private String image;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public Book() {
        this.bookID = 0;
        this.userID = 0;
        this.title = null;
        this.author = null;
        this.publisher = null;
        this.publishDate = null;
        this.description = null;
        this.image = null;
        this.price = 0;
    }

    public Book(int bookID, int userID, String title, String author, String publisher, String publishDate, String description, String image, double price) {
        // 含参构造方法
        this.bookID = bookID;
        this.userID = userID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public Book(int userID, String title, String author, String publisher, String publishDate, String description, String image, double price) {
        this.bookID = 0;
        this.userID = userID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
