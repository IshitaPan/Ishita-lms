package com.lms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bid;
    @NotBlank(message = "Username cannot be empty")
    private String btitle;
    @NotBlank(message = "Username cannot be empty")
    private String author;
    @NotBlank(message = "Username cannot be empty")
    private String isbn;
    private String genre;
    @NotBlank(message = "Username cannot be empty")
    private String pub_year;
    private boolean availability;
   
    @ManyToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;

    public Book(){
        super();
    }

    
    public Book(Long bid, @NotBlank(message = "Username cannot be empty") String btitle,
            @NotBlank(message = "Username cannot be empty") String author,
            @NotBlank(message = "Username cannot be empty") String isbn, String genre,
            @NotBlank(message = "Username cannot be empty") String pub_year, boolean availability,
            Department department) {
        this.bid = bid;
        this.btitle = btitle;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.pub_year = pub_year;
        this.availability = availability;
        this.department = department;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPub_year() {
        return pub_year;
    }

    public void setPub_year(String pub_year) {
        this.pub_year = pub_year;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Book [bid=" + bid + ", btitle=" + btitle + ", author=" + author + ", isbn=" + isbn + ", genre=" + genre
                + ", pub_year=" + pub_year + ", availability=" + availability + ", department=" + department + "]";
    }

    
    
    
}
