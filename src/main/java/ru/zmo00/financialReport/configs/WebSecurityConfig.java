package ru.zmo00.financialReport.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import ru.zmo00.financialReport.services.security.ClientDetails;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        return http.csrf().disable().build();
    }

    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(ClientDetails clientDetails) {
        UserDetailsRepositoryReactiveAuthenticationManager reactiveAuthenticationManager =
                new UserDetailsRepositoryReactiveAuthenticationManager(clientDetails);
        reactiveAuthenticationManager.setPasswordEncoder(getPasswordEncoder());
        return reactiveAuthenticationManager;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
