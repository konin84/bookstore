package com.digitaleit.bookstore.controller;

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

import com.digitaleit.bookstore.entities.Book;
import com.digitaleit.bookstore.entities.MyBookList;
import com.digitaleit.bookstore.services.BookService;
import com.digitaleit.bookstore.services.MyBooksListService;


@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBooksListService myBookListService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Book> bookList = service.getAllBooks();
//		ModelAndView mV = new ModelAndView();
//		mV.setViewName("availableBooks");
//		mV.addObject("books", bookList);
		return new ModelAndView("availableBooks", "books", bookList);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookListService.getAllMyBooks();
		model.addAttribute("books",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mbl = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookListService.saveMyBooks(mbl);
		return "redirect:/my_books";
	}
 
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "EditBook";
	}
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
