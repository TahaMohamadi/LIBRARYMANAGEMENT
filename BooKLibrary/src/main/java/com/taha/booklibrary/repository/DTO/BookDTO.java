package com.taha.booklibrary.repository.DTO;

import lombok.*;

import java.io.Serializable;


@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookDTO {
    private Long id;
    private String Name;
    private String authors;
    private String publisherFullName;
    private int count;
}