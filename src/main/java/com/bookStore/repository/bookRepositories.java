package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.Book;
@Repository
public interface bookRepositories extends JpaRepository<Book, Integer> {

}
