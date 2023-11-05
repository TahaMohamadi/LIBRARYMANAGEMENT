package com.taha.booklibrary.Service.Borrow;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.BorrowList;
import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.BorrowListResponseDTO;
import com.taha.booklibrary.repository.borrowList.BorrowListRepository;
import mapper.BorrowListMapper;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class BorrowListServiceImpl implements BorrowListService{
    private final BorrowListRepository borrowListRepository;

    public BorrowListServiceImpl(BorrowListRepository borrowListRepository) {
        this.borrowListRepository = borrowListRepository;
    }

    @Override
    public BorrowListResponseDTO borrowToMember(Member member, Book book, Date date, String description) {
        long borrowedBook = borrowListRepository.countByBookAndReturnDateNull(book);
        if (borrowedBook < book.getCount()){
            BorrowList borrowList = BorrowList.builder()
                    .borrowDate(Time.from(Instant.now()))
                    .member(member)
                    .book(book)
                    .description(description)
                    .dueDate(date)
                    .build();
            return BorrowListMapper.INSTANCE.entityToResponse(borrowListRepository.save(borrowList));
        }
        return null;

    }

    @Override
    public int returnBook(Long id, String desc, Date date) {
        return borrowListRepository.updateReturnDateAndDescriptionById(date,desc,id);
    }

    @Override
    public List<BorrowList> delayedBooK() {
        return borrowListRepository.findByReturnDateNullAndDueDateLessThan(Time.from(Instant.now()));
    }

    @Override
    public List<BorrowList> memberHistory(Member member) {
        return borrowListRepository.findByMemberOrderByBorrowDateAsc(member);
    }

    @Override
    public List<BorrowList> memberDelay(Member member) {
        Date date = Time.from(Instant.now());
        return borrowListRepository.findByMemberAndDueDateLessThan(member,date);
    }

    @Override
    public List<BorrowList> bookHistory(Book book) {
        return borrowListRepository.findByBook(book);
    }


}
