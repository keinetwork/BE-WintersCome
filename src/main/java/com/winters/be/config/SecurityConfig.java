package com.winters.be.config;

import com.winters.be.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity  //스프링 시큐리티 필터가 스프링 필터체인에 등록 됩니다.
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web)->web.ignoring().antMatchers("/","/test","/auth/**",
                "/swagger-ui/**", "/api-docs/**",
                "/favicon.ico", "/webjars/**", "/js/**", "/assets/**", "/css/**",
                "/comm/**", "/api/register"
        );
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests()
//                .antMatchers("/cms/**").hasRole("ADMIN")
//                .anyRequest().authenticated().and()
//                .httpBasic(Customizer.withDefaults())
//                .cors().disable()
//                .csrf().disable()
//                .formLogin()
                //.loginPage("/auth/loginpage.html").successForwardUrl("/").failureForwardUrl("/login-error").and()
//                .and().logout()
//                .deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutSuccessUrl("/")
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied")
//                .and()
//                .userDetailsService(userDetailsService)
                ;
//        http.oauth2Login().userInfoEndpoint().userService()
        http
                .formLogin()
                .loginPage("/page/auth/login.html")
//                .failureUrl("/page/auth/login-error.html")
                .and()
                .logout((logout)-> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/page/logout"))
                        .logoutSuccessUrl("/page/index.html").invalidateHttpSession(true)
                )
//                .logout().logoutUrl("/page/logout").logoutSuccessUrl("/page/index.html").invalidateHttpSession(true)
//                .and()
                .authorizeRequests().mvcMatchers("/page/admin/**").hasRole("ADMIN")
                                    .mvcMatchers("/page/user/**").hasRole("USER")
                                    .mvcMatchers("/page/shared/**").hasAnyRole("USER","ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/page/403.html")
                .and().cors().disable().csrf().disable()
        ;
        return http.build();
    }
//    @Bean
//    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("jim").password("{noop}demo").roles("ADMIN").build(),
//                User.withUsername("bob").password("{noop}demo").roles("USER").build(),
//                User.withUsername("ted").password("{noop}demo").roles("USER","ADMIN").build());
//    }
}
