package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lms.dao.BookRepository;
import com.lms.dao.DepartmentRepository;
import com.lms.entity.Book;
import com.lms.entity.Department;
import com.lms.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

@RequestMapping ("/add-book")
    public String add_book(Model model) {
        model.addAttribute("title", "AddBook - LMS");
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("book", new Book());
        model.addAttribute("departments", departments);
        return "addBook";
    }
    @RequestMapping ("/list-of-book")
    public String book_list(Model model,@ModelAttribute("book") Book book) {
            model.addAttribute("title", "List - LMS");
            List<Book> books = this.bookRepository.findAll();
            model.addAttribute("books", books);
            return "bookList";
        
    }
    @RequestMapping ("/search-list-of-book-by-title")
    public String search_book_list_by_title(Model model,@ModelAttribute("book") Book book) {
            model.addAttribute("title", "List - LMS");
            List<Book> books =  this.bookRepository.getBookByTitle(book.getBtitle());
            model.addAttribute("books", books);
            return "bookList";
   
    }
    @GetMapping("/delete/{bid}")
    public String delete_book(@PathVariable Long bid,Model model,HttpSession httpSession) {
        //List<Book> bookOptional = this.bookRepository.getById(bid);
        //Book book=bookOptional.getIsbn();
        this.bookRepository.deleteById(bid);
        //httpSession.setAttribute("message", new Message("Book deleted", "success"));
        return "redirect:/list-of-book";

    }
    
    @RequestMapping(value = "/save_book",method = RequestMethod.POST)
    public String saveBook(@Valid @ModelAttribute("book") Book book,@ModelAttribute("department") Department department, BindingResult res, Model model,HttpSession session)  {

        List<Department> departments = departmentRepository.findAll();
        try{
            if(res.hasErrors()){
                model.addAttribute("book", book);
                return "addBook";
            }
           book.setAvailability(true);
            if(bookRepository.existsByIsbn(book.getIsbn())==true){
                model.addAttribute("departments", departments);
                throw new Exception("Book is alreday registered!");
            }
          
            Department existDept = departmentRepository.findByName(book.getDepartment().getName());
            if(existDept != null){
                book.setDepartment(existDept);
            }
           Book result = this.bookRepository.save(book);
           model.addAttribute("book", new Book());
           model.addAttribute("departments", departments);
           session.setAttribute("message", new Message("Successfullly Saved!!","alert-success"));
           return "addBook";
        }catch(Exception e){
           e.printStackTrace();
           model.addAttribute("book", book);
           session.setAttribute("message",new Message(e.getMessage(), "alert-danger"));
           return "addBook";
        }

    }


}
