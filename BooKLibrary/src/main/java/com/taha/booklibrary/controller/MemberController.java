package com.taha.booklibrary.controller;

import com.taha.booklibrary.Service.Member.MemberService;
import com.taha.booklibrary.repository.DTO.MemberDTO;
import mapper.MemberMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/addMember")
    public MemberDTO addMember(@RequestBody MemberDTO memberDTO){
        try {
            return MemberMapper.INSTANCE.toDTO(memberService.saveMember(memberDTO));
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/deleteMember")
    public void deleteMember(@RequestParam Long id){
        try {
            memberService.deleteMember(id);
        }catch (Exception e){
        }
    }

    @PutMapping("/updateMember")
    public int updateMember(@RequestBody MemberDTO memberDTO){
        try {
            return memberService.updateMember(memberDTO);
        }catch (Exception e){
            return 0;
            }
    }

}
