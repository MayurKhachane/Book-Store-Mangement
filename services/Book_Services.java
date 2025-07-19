package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repositry.Book_Respositry;

@Service
public class Book_Services {

    @Autowired
    private Book_Respositry repo;

    public void save(Book b) {
        repo.save(b);
    }

    public List<Book> ListBook() {
        return repo.findAll();
    }
    
    public Book getBookbyId(int id) {
    	return repo.findById(id).get();
    }
    
    public void DeleteBookId(int id) {
    	repo.deleteById(id);
    }
}
