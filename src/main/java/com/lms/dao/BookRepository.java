package com.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    public boolean existsByIsbn(String isbn);
    
     @Query(value="SELECT * FROM book WHERE btitle LIKE %:btitle%",nativeQuery  =true)
     public List<Book> getBookByTitle(@Param("btitle") String btitle);

    //  @Query(value="SELECT * FROM book WHERE btitle LIKE %:btitle% OR btitle LIKE %:author% ",nativeQuery  =true)
    //  public List<Book> getBookByTitle(@Param("btitle") String btitle,@Param("author") String author);

     @Query(value="select * from book  where author=:author",nativeQuery  =true)
     public List<Book> getBookByAuthor(@Param("author") String author);
    
}
