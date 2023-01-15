package spring.proj.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.proj.shop.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
