package com.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    public boolean existsByIsbn(String isbn);
    
     @Query(value="select * from book  where btitle=:btitle",nativeQuery  =true)
     public List<Book> getBookByTitle(@Param("btitle") String btitle);

     @Query(value="select * from book  where author=:author",nativeQuery  =true)
     public List<Book> getBookByAuthor(@Param("author") String author);
    
}
