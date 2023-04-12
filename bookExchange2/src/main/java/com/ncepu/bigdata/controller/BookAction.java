package com.ncepu.bigdata.controller;

import com.ncepu.bigdata.entity.Book;
import com.ncepu.bigdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Controller
@RequestMapping("/book")
public class BookAction {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    @ResponseBody
    public Book getBook(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/getBook")
    public List<Book> getBooks(@RequestParam("start") int start,@RequestParam("end") int end){
        int MAX_BOOK_ID = 100;
        int MAX_USER_ID = 100;
        String[] TITLES = {"Java Programming", "C++ Basics", "Python Cookbook", "Data Structures and Algorithms", "Web Development 101", "Machine Learning for Beginners", "Network Security Fundamentals", "Artificial Intelligence and Ethics"};
        String[] AUTHORS = {"Alice Smith", "Bob Johnson", "Charlie Brown", "David Lee", "Emily Chen", "Frank Williams", "Grace Davis", "Henry Thompson"};
        String[] PUBLISHERS = {"O'Reilly Media", "Addison-Wesley Professional", "Manning Publications", "Packt Publishing", "Wiley", "McGraw-Hill Education", "Pearson Education", "Springer"};
        String[] DESCRIPTIONS = {"This book is a comprehensive guide to Java programming.", "This book covers the basics of C++ programming.", "This book contains a collection of Python recipes for common tasks.", "This book covers various data structures and algorithms used in programming.", "This book provides an introduction to web development using HTML, CSS, and JavaScript.", "This book is a gentle introduction to machine learning concepts and techniques.", "This book covers fundamental network security concepts and techniques.", "This book discusses the ethical considerations of artificial intelligence."};
        String[] IMAGE_URLS = {"https://i.imgur.com/KFtNlNl.jpg", "https://i.imgur.com/rbdZYJd.jpg", "https://i.imgur.com/hitBNNx.jpg", "https://i.imgur.com/yzxSt7B.jpg", "https://i.imgur.com/iW9tPYJ.jpg", "https://i.imgur.com/5wOzL0F.jpg", "https://i.imgur.com/dOHEWSh.jpg", "https://i.imgur.com/6UEyvyN.jpg"};
        List<Book> bookList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int bookID = random.nextInt(MAX_BOOK_ID) + 1;
            int userID = random.nextInt(MAX_USER_ID) + 1;
            String title = TITLES[random.nextInt(TITLES.length)];
            String author = AUTHORS[random.nextInt(AUTHORS.length)];
            String publisher = PUBLISHERS[random.nextInt(PUBLISHERS.length)];
            String publishDate = String.format("%04d-%02d-%02d", 2000 + random.nextInt(21), random.nextInt(12) + 1, random.nextInt(28) + 1);
            String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
            String image = IMAGE_URLS[random.nextInt(IMAGE_URLS.length)];
            double price = random.nextDouble() * 100.0;
            Book book = new Book(bookID, userID, title, author, publisher, publishDate, description, image, price);
            bookList.add(book);
        }
        return bookList;
        //return bookService.getBookByRG(start,end);
    }
    @PostMapping("/add")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "success";
    }

    @PutMapping("/{bookId}")
    @ResponseBody
    public String updateBook(@PathVariable int bookId, @RequestBody Book book) {
        book.setBookID(bookId);
        bookService.updateBook(book);
        return "success";
    }

    @DeleteMapping("/{bookId}")
    @ResponseBody
    public String deleteBook(@PathVariable int bookId) {
        bookService.deleteBookById(bookId);
        return "success";
    }
}
