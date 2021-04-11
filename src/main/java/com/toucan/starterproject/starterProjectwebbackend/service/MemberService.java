package com.toucan.starterproject.starterProjectwebbackend.service;

import java.util.List;
import java.util.Optional;

import com.toucan.starterproject.starterProjectwebbackend.domain.Member;
import com.toucan.starterproject.starterProjectwebbackend.repository.MemberRepository;
import com.toucan.starterproject.starterProjectwebbackend.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository=new MemoryMemberRepository();


    public Long join(Member member){
        validateDuplicateMember(member);  
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("Member already exists.");
        });
    }
    

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}