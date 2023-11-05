package com.taha.booklibrary.Service.Book;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.Book.BookRepository;
import com.taha.booklibrary.repository.DTO.BookDTO;
import mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
         return bookRepository.save(BookMapper.INSTANCE.toEntity(bookDTO));
    }

    @Override
    public int updateBook(BookDTO bookDTO) {
         return bookRepository.updateNameAndAuthorsAndPublisherFullNameAndCountById(bookDTO.getName(), bookDTO.getAuthors(), bookDTO.getPublisherFullName(), bookDTO.getCount(),  bookDTO.getId());
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }
}
