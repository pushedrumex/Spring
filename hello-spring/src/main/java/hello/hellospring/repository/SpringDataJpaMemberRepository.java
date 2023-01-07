package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//  JpaRepository를 상속받고 있으면 spring-data-jpa가 구현체를 자동으로 spring bean에 등록 해줌
//  JpaRepository에 기본적인 메서드들(save, findAll, findById, ... ) 이미 구현 되어 있음
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from Member m where m.name = ? 으로 자동 생성 ㄹㅇ 신기
    @Override
    Optional<Member> findByName(String name);
}
