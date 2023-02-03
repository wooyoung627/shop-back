package spring.proj.shop.repository.member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.proj.shop.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryDsl {

}
