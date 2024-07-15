package com.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Department cannot be blank")
    private String name;

    // @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Book> books=new ArrayList<>();;
    
    public Department(){
        super();
    }
   
    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
        //this.books = books;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    


    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }


    // public List<Book> getBooks() {
    //     return books;
    // }


    // public void setBooks(List<Book> books) {
    //     this.books = books;
    // }

    
    
    
}
