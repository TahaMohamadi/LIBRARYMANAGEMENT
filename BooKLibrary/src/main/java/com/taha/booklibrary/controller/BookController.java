package com.taha.booklibrary.controller;

import com.taha.booklibrary.Service.Book.BookService;
import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.repository.DTO.BookDTO;
import mapper.BookMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public BookDTO addBook(@RequestBody BookDTO bookDTO){
        try{

            Book bd = bookService.saveBook(bookDTO);
            return BookMapper.INSTANCE.toDTO(bd);
        }catch (Exception e){
            return null;
        }
    }
    @DeleteMapping("/deleteBook")
    public void deleteBook(@RequestParam Long id){
        try{
            bookService.deleteBook(id);
        }catch (Exception e){
        }
    }
    @PutMapping("/updateBook")
    public int updateBook(@RequestBody BookDTO bookDTO){
        try{
            return bookService.updateBook(bookDTO);
        }catch (Exception e){
            return 0;
        }
    }
}
