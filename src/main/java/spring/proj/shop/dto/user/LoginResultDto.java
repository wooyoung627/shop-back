package spring.proj.shop.dto.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Getter
public class LoginResultDto {

    private boolean result;

    private String id;
    private String authority;

    public LoginResultDto() {
    }

    @Builder
    public LoginResultDto(boolean result, String id, Collection<? extends GrantedAuthority> authorities) {
        this.result = result;
        this.id = id;

        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        if (iterator.hasNext()) {
            this.authority = iterator.next().getAuthority();
        }
    }

}
