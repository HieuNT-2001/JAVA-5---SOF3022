package com.fpoly.chua_de_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.chua_de_2.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
