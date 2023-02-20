package spring.proj.shop.dto.user;

import lombok.Getter;
import lombok.ToString;
import spring.proj.shop.entity.user.UserRole;

@Getter
@ToString
public class JoinUserDto {

    private String userId;
    private String password;
    private UserRole role;

}
