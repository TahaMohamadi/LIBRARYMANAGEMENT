package com.taha.booklibrary.Service.Borrow;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.BorrowList;
import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.BorrowListResponseDTO;

import java.util.Date;
import java.util.List;

public interface BorrowListService {
    BorrowListResponseDTO borrowToMember(Member member, Book book, Date date, String description);
    int returnBook(Long id,String desc, Date date);
    List<BorrowList> delayedBooK();
    List<BorrowList> memberHistory(Member member);
    List<BorrowList> memberDelay(Member member);
    List<BorrowList> bookHistory(Book book);
}
