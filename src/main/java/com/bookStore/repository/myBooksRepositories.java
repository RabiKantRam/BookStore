package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.myBookList;
@Repository
public interface myBooksRepositories extends JpaRepository<myBookList, Integer> {

}
