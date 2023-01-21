package spring.proj.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.proj.shop.entity.Team;
import spring.proj.shop.entity.TeamId;

public interface TeamRepository extends JpaRepository<Team, TeamId> {
    Team findTeamById(Long id);
}
