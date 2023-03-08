package spring.proj.shop.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import spring.proj.shop.dto.user.LoginResultDto;
import spring.proj.shop.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static spring.proj.shop.util.JsonUtil.*;

@Slf4j
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info("AuthenticationSuccess [{}]", authentication.getPrincipal());

        response.getWriter().print(
                toJson(LoginResultDto.builder().result(true).id(authentication.getName()).authorities(authentication.getAuthorities()).build()));
    }

}
