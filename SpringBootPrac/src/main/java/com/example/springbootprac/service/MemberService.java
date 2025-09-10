package com.example.springbootprac.service;

import com.example.springbootprac.repository.MemberRepository;
import com.example.springbootprac.repository.MemoryMemberRepository;
import com.example.springbootprac.domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//회원가입
    public Long join(Member member) {
        //같은 이름 중복회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
        .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    //회원전체조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberid){
        return memberRepository.findById(memberid);
    }
}
