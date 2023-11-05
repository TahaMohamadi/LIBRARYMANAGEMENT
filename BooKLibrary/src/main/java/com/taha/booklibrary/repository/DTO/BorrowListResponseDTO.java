package com.taha.booklibrary.repository.DTO;

import com.taha.booklibrary.entity.Book;
import com.taha.booklibrary.entity.Member;
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
public class BorrowListResponseDTO {
    private Long id;
    private String book;
    private String  member;
    private Date borrowDate;
    private Date returnDate;
    private Date dueDate;
    private String description;
}
