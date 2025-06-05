package com.bookstore.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.api.dtos.BookRecordDto;
import com.bookstore.api.models.BookModel;
import com.bookstore.api.models.ReviewModel;
import com.bookstore.api.repositories.AuthorRepositoy;
import com.bookstore.api.repositories.BookRepository;
import com.bookstore.api.repositories.PublisherRepositoy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
   private final BookRepository bookRepository;
   private final AuthorRepositoy authorRepository;
   private final PublisherRepositoy publisherRepository;

   public BookService(BookRepository bookRepository, AuthorRepositoy authorRepository,
         PublisherRepositoy publisherRepository) {
      this.bookRepository = bookRepository;
      this.authorRepository = authorRepository;
      this.publisherRepository = publisherRepository;
   }

   public List<BookModel> getAllBooks() {
      return bookRepository.findAll();
   }

   @Transactional
   public BookModel saveBook(BookRecordDto bookRecordDto) {
      BookModel book = new BookModel();
      book.setTitle(bookRecordDto.title());
      book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
      // .orElseThrow(() -> new RuntimeException("Publisher not found")));
      book.setAuthors(authorRepository
            .findAllById(bookRecordDto.authorIds())
            .stream()
            .collect(Collectors.toSet()));

      ReviewModel reviewModel = new ReviewModel();
      reviewModel.setComment(bookRecordDto.reviewComment());
      reviewModel.setBook(book);
      book.setReview(reviewModel);
      return bookRepository.save(book);
   }

   @Transactional
   public void deleteBook(UUID id) {
      bookRepository.deleteById(id);
   }
}
