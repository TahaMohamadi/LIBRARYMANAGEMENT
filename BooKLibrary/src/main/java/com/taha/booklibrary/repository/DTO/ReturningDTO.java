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
public class ReturningDTO {
    private Long id;
    private String desc;
    private Date date;
}
