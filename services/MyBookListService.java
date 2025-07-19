package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyBookList;
import com.example.demo.repositry.MyBookRepositry;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepositry myBookRepos;
	
	public void SaveMyBook(MyBookList mybook) {
		myBookRepos.save(mybook);
	}
	
	public List<MyBookList> getAllList(){
		return myBookRepos.findAll();
	}
	public void DeleteById(int id) {
		myBookRepos.deleteById(id);
	}
}
