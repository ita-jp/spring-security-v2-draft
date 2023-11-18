package com.example.securedapp.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // for http://localhost:8080/h2-console
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(antMatcher("/h2-console/**")).permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(antMatcher("/h2-console/**"))
                )
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
                );

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
                )
                .userDetailsService(userDetailsService);

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
