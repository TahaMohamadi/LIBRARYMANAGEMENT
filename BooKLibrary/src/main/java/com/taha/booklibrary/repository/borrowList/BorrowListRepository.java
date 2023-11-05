package com.taha.booklibrary.repository.borrowList;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.BorrowList;
import com.taha.booklibrary.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowListRepository extends JpaRepository<BorrowList, Long> {
    @Query("select b from BorrowList b where b.book = ?1")
    List<BorrowList> findByBook(Book book);
    @Query("select b from BorrowList b where b.member = ?1 and b.dueDate < ?2")
    List<BorrowList> findByMemberAndDueDateLessThan(Member member, Date dueDate);
    @Query("select b from BorrowList b where b.member = ?1 order by b.borrowDate")
    List<BorrowList> findByMemberOrderByBorrowDateAsc(Member member);
    @Query("select b from BorrowList b where b.returnDate is null and b.dueDate < ?1")
    List<BorrowList> findByReturnDateNullAndDueDateLessThan(Date today);
    long countByBookAndReturnDateNull(Book book);
    @Query("select count(b) from BorrowList b where b.book.id = ?1 and b.returnDate is null")
    long countByBook_IdAndReturnDateNull(Long id);
    @Transactional
    @Modifying
    @Query("update BorrowList b set b.returnDate = ?1, b.description = ?2 where b.id = ?3")
    int updateReturnDateAndDescriptionById(Date returnDate, @Nullable String description, Long id);
}
