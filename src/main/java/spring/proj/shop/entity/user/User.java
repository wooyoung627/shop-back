package spring.proj.shop.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user_info")
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime createDt;

    @Builder
    public User(String userId, String password, UserRole role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.createDt = LocalDateTime.now();
    }
}
