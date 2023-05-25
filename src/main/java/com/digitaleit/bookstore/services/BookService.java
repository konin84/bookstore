package com.digitaleit.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaleit.bookstore.entities.Book;
import com.digitaleit.bookstore.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public void save(Book b) {
		bookRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
		
	}

}
