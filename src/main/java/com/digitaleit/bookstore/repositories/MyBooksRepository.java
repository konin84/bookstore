package com.digitaleit.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitaleit.bookstore.entities.MyBookList;

public interface MyBooksRepository extends JpaRepository<MyBookList, Integer> {

}
