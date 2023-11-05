package com.taha.booklibrary.Service.Member;

import com.taha.booklibrary.entity.Member;
import com.taha.booklibrary.repository.DTO.MemberDTO;
import com.taha.booklibrary.repository.member.MemberRepository;
import mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(MemberDTO memberDTO) {

        return memberRepository.save(MemberMapper.INSTANCE.toEntity(memberDTO));
    }

    @Override
    public int updateMember(MemberDTO memberDTO) {
        return memberRepository.updateMember(memberDTO.getFullName(), memberDTO.getMobileNumber(), memberDTO.getId());
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member getById(Long id) {
        return memberRepository.getById(id);
    }
}
