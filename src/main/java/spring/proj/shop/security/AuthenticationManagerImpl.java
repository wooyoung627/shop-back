package spring.proj.shop.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import spring.proj.shop.dto.user.LoginUserDto;
import spring.proj.shop.entity.user.User;
import spring.proj.shop.service.user.UserService;

/**
 * AuthenticationManager : Spring Security 필터가 인증을 수행하는 방법을 정의
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationManagerImpl implements AuthenticationManager {

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        LoginUserDto loginUser = userService.login(userId, password);
        return new UsernamePasswordAuthenticationToken(userId, loginUser.getPassword(), loginUser.getRoles());
    }
}
