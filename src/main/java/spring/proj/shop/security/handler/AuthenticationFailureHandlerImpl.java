package spring.proj.shop.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import spring.proj.shop.dto.user.LoginResultDto;
import spring.proj.shop.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static spring.proj.shop.util.JsonUtil.*;

@Slf4j
@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("AuthenticationFailureHandler [{}]", exception.getMessage());
        response.getWriter().print(toJson(LoginResultDto.builder().result(false).build()));
    }
}
