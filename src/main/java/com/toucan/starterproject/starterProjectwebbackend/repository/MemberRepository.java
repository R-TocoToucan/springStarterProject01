package com.toucan.starterproject.starterProjectwebbackend.repository;
import java.util.List;
import java.util.Optional;
import com.toucan.starterproject.starterProjectwebbackend.domain.Member;

public interface MemberRepository {

	Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    
}