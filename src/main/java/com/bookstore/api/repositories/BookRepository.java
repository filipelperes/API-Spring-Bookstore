package com.bookstore.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.api.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
   BookModel finBookModelByTitle(String title);

   @Query(value = "SELECT b FROM BookModel b WHERE b.title = ?1", nativeQuery = true)
   BookModel findBookByTitle(String title);
}
