package com.example.tacocloud.tacos.security;

import com.example.tacocloud.tacos.data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 *
 * @author marat
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService(UserRepository repository) {
        
        return username -> {
            
            User user = repository.findByUsername(username);
            if (null != user) {
                return user;
            } else {
                throw new UsernameNotFoundException("User '" + username + "' not found");
            }
        };
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeHttpRequests
                        -> authorizeHttpRequests
                        .requestMatchers("/design", "/orders").hasRole("USER")
                        .requestMatchers("/login", "/", "/**").permitAll() // Разрешаем доступ к публичным страницам
                )
                .formLogin(formLogin
                        -> formLogin
                        .loginPage("/login") // Указываем свою страницу логина
                        .defaultSuccessUrl("/", true)
                        .permitAll() // Разрешаем всем доступ к странице логина
                )
                .logout(logout
                        -> logout
                        .logoutSuccessUrl("/")
                        .permitAll() // Разрешаем всем доступ к странице логаута
                )
                .csrf(csrf
                        -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Включение защиты CSRF
                );
        
        return http.build();
    }
    
}
