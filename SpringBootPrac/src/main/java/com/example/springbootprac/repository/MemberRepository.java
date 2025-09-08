package com.example.springbootprac.repository;

import com.example.springbootprac.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String name);
    List<Member> findAll();
}
