package com.example.springbootprac.repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.springbootprac.domain.Member;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();//테스트가 실행이되고 끝날떄마다 레포지토리 (저장소)를 다지움
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        repository.findById(member.getId()).get();

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("kanghee");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kangman");
        repository.save(member2);

        Member result = repository.findByName("kanghee").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("kanghee");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kangman");
        repository.save(member2);
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }


}
