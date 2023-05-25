package com.digitaleit.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaleit.bookstore.entities.MyBookList;
import com.digitaleit.bookstore.repositories.MyBooksRepository;

@Service
public class MyBooksListService {
	
	@Autowired
	private MyBooksRepository mybooks;
	
	public void saveMyBooks(MyBookList book) {
		mybooks.save(book);
		
	}
	
	public List<MyBookList> getAllMyBooks() {
		return mybooks.findAll();
	}

	public void deleteById(int id) {
		mybooks.deleteById(id);
	}

	

}
