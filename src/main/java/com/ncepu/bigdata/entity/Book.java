package com.ncepu.bigdata.entity;

public class Book {
    private int book_ID;
    private int user_ID;
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
        this.book_ID = 0;
        this.user_ID = 0;
        this.title = null;
        this.author = null;
        this.publisher = null;
        this.publishDate = null;
        this.description = null;
        this.image = null;
        this.price = 0;
    }

    public Book(int book_ID, int user_ID, String title, String author, String publisher, String publishDate, String description, String image, double price) {
        // 含参构造方法
        this.book_ID = book_ID;
        this.user_ID = user_ID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public Book(int user_ID, String title, String author, String publisher, String publishDate, String description, String image, double price) {
        this.book_ID = 0;
        this.user_ID = user_ID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
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
