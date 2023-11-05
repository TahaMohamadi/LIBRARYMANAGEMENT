package com.taha.booklibrary.repository.DTO;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BorrowListDTO {
    private Long id;
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;
    private Date dueDate;
    private String description;
}
