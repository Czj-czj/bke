package com.ncepu.bigdata.mapper;
import com.ncepu.bigdata.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    @Select("SELECT * FROM Book WHERE Book_ID = #{bookID}")
    Book getBookByID(@Param("bookID") int bookID);

    @Select("SELECT * FROM Book WHERE Book_ID > #{start} and Book_ID < #{end}")
    Book getBookByRG(@Param("start") int start,@Param("end") int end);

    @Select("SELECT * FROM Book")
    List<Book> getAllBooks();

    @Insert("INSERT INTO Book (User_ID, Title, Author, Publisher, Publish_Date, Description, Image) " +
            "VALUES (#{book.userID}, #{book.title}, #{book.author}, #{book.publisher}, " +
            "#{book.publishDate}, #{book.description}, #{book.image})")
    @Options(useGeneratedKeys = true, keyProperty = "book.bookID")
    void addBook(@Param("book") Book book);

    @Update("UPDATE Book SET Title = #{book.title}, Author = #{book.author}, " +
            "Publisher = #{book.publisher}, Publish_Date = #{book.publishDate}, " +
            "Description = #{book.description}, Image = #{book.image} " +
            "WHERE Book_ID = #{book.bookID}")
    void updateBook(@Param("book") Book book);

    @Delete("DELETE FROM Book WHERE Book_ID = #{bookID}")
    void deleteBook(@Param("bookID") int bookID);
}

