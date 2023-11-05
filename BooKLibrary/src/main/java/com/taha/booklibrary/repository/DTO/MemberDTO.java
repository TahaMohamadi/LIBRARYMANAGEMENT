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
public class MemberDTO{
    Long id;
    String fullName;
    String mobileNumber;
}