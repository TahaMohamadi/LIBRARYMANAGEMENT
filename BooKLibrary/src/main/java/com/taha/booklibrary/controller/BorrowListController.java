package com.taha.booklibrary.controller;

import com.taha.booklibrary.Service.Book.BookService;
import com.taha.booklibrary.Service.Borrow.BorrowListService;
import com.taha.booklibrary.Service.Member.MemberService;
import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.BorrowList;
import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.BorrowDTO;
import com.taha.booklibrary.repository.DTO.BorrowListResponseDTO;
import com.taha.booklibrary.repository.DTO.ReturningDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowListController {
    private final BorrowListService borrowListService;
    private final MemberService memberService;
    private final BookService bookService;
    public BorrowListController(BorrowListService borrowListService, MemberService memberService, BookService bookService) {
        this.borrowListService = borrowListService;
        this.memberService = memberService;
        this.bookService = bookService;
    }
    @PostMapping("/borrowToMember")
    public BorrowListResponseDTO borrowToMember(@RequestBody BorrowDTO borrowDTO){
        try {
            Member member = memberService.getById(borrowDTO.getMemberId());
            Book book = bookService.getBookById(borrowDTO.getBookId());
            return borrowListService.borrowToMember(member, book, borrowDTO.getDate(), borrowDTO.getDescription());
        }catch (Exception e){
            return null;
        }
    }

    @PutMapping("/returningBook")
    public int returnBook(@RequestBody ReturningDTO returningDTO){
        try {
        return borrowListService.returnBook(returningDTO.getId(), returningDTO.getDesc(), returningDTO.getDate());
    }catch (Exception e){
        return 0;
    }
    }
    @GetMapping("/delayedBooKs")
    public List<BorrowList> delayedBooK(){
        try {
        return borrowListService.delayedBooK();
    }catch (Exception e){
        return null;
        }
    }
    @GetMapping("/memberHistory")
    public List<BorrowList> memberHistory(Member member){
        try {
        return borrowListService.memberHistory(member);
        }catch (Exception e){
        return null;
        }
    }
    @GetMapping("/memberDelay")
    public List<BorrowList> memberDelay(Member member){
        try {
        return borrowListService.memberDelay(member);
        }catch (Exception e){
        return null;
        }

    }
    @GetMapping("/bookHistory")

    public List<BorrowList> bookHistory(Book book){
        try {
        return borrowListService.bookHistory(book);
        }catch (Exception e){
        return null;
        }
    }

}
