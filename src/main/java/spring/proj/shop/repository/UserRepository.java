package spring.proj.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.proj.shop.entity.user.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUserId(String userId);

}
