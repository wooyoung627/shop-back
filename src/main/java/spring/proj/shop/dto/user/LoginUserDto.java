package spring.proj.shop.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import spring.proj.shop.entity.user.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class LoginUserDto {

    private String userId;
    private String password;
    private final List<SimpleGrantedAuthority> roles = new ArrayList<>();

    public LoginUserDto(User user) {
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.roles.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
    }
}
