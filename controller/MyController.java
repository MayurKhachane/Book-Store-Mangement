package com.example.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Book;
import com.example.demo.entity.MyBookList;
import com.example.demo.services.Book_Services;
import com.example.demo.services.MyBookListService;

@Controller
public class MyController {

    @Autowired
    private Book_Services book_Services;
    
    @Autowired
    private MyBookListService myList;

    @GetMapping("/")
    public String getMethodName() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/Avaiable_book")
    public ModelAndView findbooks() {
        List<Book> list = book_Services.ListBook();
        return new ModelAndView("findbook", "Book", list);
    }

    @PostMapping("/save")
    public String addbooks(@ModelAttribute Book b) {
        book_Services.save(b);
        return "redirect:/Avaiable_book";
    }
    
    @GetMapping("/my_book")
    public String MyBooks(Model model) {
    	List<MyBookList> list = myList.getAllList();
    	model.addAttribute("Book", list);
    	
    	return "mybooks";
    }
  
    @RequestMapping("/mylist/{id}")
    public String getMyBook(@PathVariable("id") int id) {
        Book b = book_Services.getBookbyId(id);
           
        MyBookList mb = new MyBookList();
        mb.setName(b.getName());
        mb.setAuthor(b.getAuthor());
        mb.setPrice(b.getPrice());

        myList.SaveMyBook(mb);
        return "redirect:/my_book";
    }

    @RequestMapping("/editbook/{id}")
    public String EditBook(@PathVariable("id") int id, Model model) {
    	Book b = book_Services.getBookbyId(id);
    	model.addAttribute("Book", b);
    	return "booklist";
    }
    
    @RequestMapping("/deleteBook/{id}")
    public String DeleteBook(@PathVariable("id") int id) {
    	book_Services.DeleteBookId(id);
    	return "redirect:/Avaiable_book";
    }
}
