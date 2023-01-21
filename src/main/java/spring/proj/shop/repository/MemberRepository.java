package spring.proj.shop.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.proj.shop.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryDsl {

    @EntityGraph(attributePaths = {"team"})
    Member findEntityGraphById(Long id);
}
