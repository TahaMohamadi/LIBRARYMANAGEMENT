package com.taha.booklibrary.Service.Book;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.BookDTO;

public interface BookService {
     Book saveBook(BookDTO bookDTO);
     int updateBook(BookDTO bookDTO);
     void deleteBook(Long bookId);
     Book getBookById(Long Id);
}
