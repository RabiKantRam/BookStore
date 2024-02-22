package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.myBookList;
import com.bookStore.repository.myBooksRepositories;

@Service
public class myBookService {
		
	
		@Autowired
		myBooksRepositories mybookrepo;
		
		public void saveMyBooks(myBookList mb) {
			mybookrepo.save(mb);
		}
		
		public List<myBookList> getAllMyBooks(){
			return mybookrepo.findAll();
		}
		
		public void deleteById(int id) {
			mybookrepo.deleteById(id);
		}

}

