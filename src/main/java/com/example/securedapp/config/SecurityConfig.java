package com.example.securedapp.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(new LoginLogoutRequestMatcher()).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        //.usernameParameter("username")
                        //.passwordParameter("password")
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // この設定はデフォルト値なので省略可
                        .logoutSuccessUrl("/login?logout") // この設定はデフォルト値なので省略可
                );

        return http.build();
    }

    /**
     * リクエストが {@code /login?logout} かどうかを判定する RequestMatcher
     */
    private static class LoginLogoutRequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            return "/login".equals(request.getServletPath())
                    && "".equals(request.getParameter("logout"));
        }
    }
}
