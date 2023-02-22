package spring.proj.shop.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring.proj.shop.entity.user.UserRole;
import spring.proj.shop.security.AuthenticationManagerImpl;
import spring.proj.shop.security.SecurityFilter;
import spring.proj.shop.security.handler.AccessDeniedHandlerImpl;
import spring.proj.shop.security.handler.AuthenticationEntryPointImpl;
import spring.proj.shop.security.handler.AuthenticationFailureHandlerImpl;
import spring.proj.shop.security.handler.AuthenticationSuccessHandlerImpl;

import static spring.proj.shop.entity.user.UserRole.*;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationManagerImpl authenticationManager;
    private final AuthenticationSuccessHandlerImpl successHandler;
    private final AuthenticationFailureHandlerImpl failureHandler;
    private final AccessDeniedHandlerImpl accessDeniedHandler;
    private final AuthenticationEntryPointImpl authenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) ->
                requests.antMatchers("/un-auth/**").permitAll()
                        .antMatchers("/admin/**").hasRole(ADMIN.name())
                        .antMatchers("/user/**").hasRole(USER.name())
                        .anyRequest().authenticated())

//                .formLogin().disable()

//                .addFilterBefore(
//                        new SecurityFilter("/login", authenticationManager, successHandler, failureHandler),
//                        UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling(e ->
                        e.accessDeniedHandler(accessDeniedHandler)
                                .authenticationEntryPoint(authenticationEntryPoint))

                .oauth2Login()

                .and()
                .csrf().disable();
        return http.build();
    }

}
