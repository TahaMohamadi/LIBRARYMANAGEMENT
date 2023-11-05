package com.taha.booklibrary.repository.DTO;

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
public class BorrowDTO {
    private Long memberId;
    private Long bookId;
    private Date date;
    private String description;
}
