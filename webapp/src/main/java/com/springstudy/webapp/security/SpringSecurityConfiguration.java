package com.springstudy.webapp.security;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    UserDetails userDetails1 = createNewUser("seungjae", "1111");
    UserDetails userDetails2 = createNewUser("mario", "2222");

    return new InMemoryUserDetailsManager(userDetails1, userDetails2);
  }

  private UserDetails createNewUser(String username, String password) {
    Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
    UserDetails userDetails =
        User.builder()
            .passwordEncoder(passwordEncoder)
            .username(username)
            .password(password)
            .roles("admin", "user")
            .build();
    return userDetails;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // 기본적으로 설정되는 두 가지 값
  // 모든 URL은 보호됨
  // 인가 받지 않은 요청은 로그인 폼이 뜸
  // 사이트간 요청 변조 CSRF를 비활성화
  // 프레임 활성화

  // CSRF
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
    http.formLogin(Customizer.withDefaults());
    http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**").disable());
    http.headers(
        HttpHeaders -> HttpHeaders.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
    return http.build();
  }
}
