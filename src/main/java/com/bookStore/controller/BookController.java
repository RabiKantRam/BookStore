package com.bookStore.controller;

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

import com.bookStore.entity.Book;
import com.bookStore.entity.myBookList;
import com.bookStore.service.bookService;
import com.bookStore.service.myBookService;

@Controller
public class BookController {
	@Autowired
	private bookService service;
	@Autowired
	private myBookService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/my_books")
	public String mybook(Model model) {
		List<myBookList> list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@GetMapping("/avaliable_books")
	public ModelAndView avaliableBooks() {
		List<Book> list=service.getAllBooks();
		
		return new ModelAndView("avaliableBooks","book",list);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/avaliable_books"; 
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		myBookList ml=new myBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(ml);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "BookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/avaliable_books";
	}
}
