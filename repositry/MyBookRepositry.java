package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MyBookList;

@Repository
public interface MyBookRepositry extends JpaRepository<MyBookList, Integer>{

}
