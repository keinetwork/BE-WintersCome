package com.winters.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->web.ignoring().antMatchers("/","/test","/api/login",
                "/swagger-ui/**", "/api-docs/**",
                "/favicon.ico", "/webjars/**", "/js/**", "/assets/**", "/css/**",
                "/comm/**", "/api/register"
        );
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/cms/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .httpBasic(Customizer.withDefaults())
                .cors().disable()
                .csrf().disable()
                .formLogin().loginPage("/api/login").successForwardUrl("/").and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/")
                ;
        return http.build();
    }
}
