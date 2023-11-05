package com.taha.booklibrary.repository.member;

import com.taha.booklibrary.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Transactional
    @Modifying
    @Query("update Member m set m.fullName = ?1, m.mobileNumber = ?2 where m.id = ?3")
    int updateMember(@Nullable String fullName, @Nullable String mobileNumber, Long id);
    @Transactional
    @Modifying
    @Query("update Member m set m.fullName = ?1, m.mobileNumber = ?2 where m.id = ?3")
    int updateFullNameAndMobileNumberById(String fullName, String mobileNumber, Long id);
}
