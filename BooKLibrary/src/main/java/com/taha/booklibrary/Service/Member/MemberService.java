package com.taha.booklibrary.Service.Member;

import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.MemberDTO;

public interface MemberService {
    Member saveMember(MemberDTO memberDTO);
    int updateMember(MemberDTO memberDTO);
    void deleteMember(Long id);
    Member getById(Long id);
}
