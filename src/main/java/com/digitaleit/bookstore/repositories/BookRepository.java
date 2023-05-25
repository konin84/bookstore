package com.digitaleit.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitaleit.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
