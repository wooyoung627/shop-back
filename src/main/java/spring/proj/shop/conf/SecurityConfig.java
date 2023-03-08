package spring.proj.shop.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import spring.proj.shop.entity.user.UserRole;
import spring.proj.shop.security.AuthenticationManagerImpl;
import spring.proj.shop.security.handler.*;

import static spring.proj.shop.entity.user.UserRole.*;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationSuccessHandlerImpl successHandler;
    private final AuthenticationFailureHandlerImpl failureHandler;
    private final AccessDeniedHandlerImpl accessDeniedHandler;
    private final AuthenticationEntryPointImpl authenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) ->
                requests
                        .antMatchers("/admin/**").hasRole(ADMIN.name())
                        .antMatchers("/user/**").hasRole(USER.name())
                        .anyRequest().permitAll())

                .formLogin((formLogin) ->
                        formLogin
                                .usernameParameter("userId")
                                .passwordParameter("password")
                                .successHandler(successHandler)
                                .failureHandler(failureHandler)
                                .loginProcessingUrl("/login"))

                .exceptionHandling(e ->
                        e.accessDeniedHandler(accessDeniedHandler)
                                .authenticationEntryPoint(authenticationEntryPoint))

                .oauth2Login()

                .and()
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
