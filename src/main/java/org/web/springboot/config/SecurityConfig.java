package org.web.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  private static final String[] PUBLIC_URLS = {
    "/", "/login", "/css/**", "/images/**", "/js/**"
  };

  @Bean
  public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

    configureAuthorization(http);
    configureLogin(http);
    configureLogout(http);
    configureH2Console(http);
    return http.build();
  }

  private void configureAuthorization (HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
      .requestMatchers(PUBLIC_URLS)
      .permitAll()
      .anyRequest()
      .authenticated()
    );
  }

  private void configureLogin (HttpSecurity http) throws Exception {
    http.formLogin(form -> form
      .loginPage("/login")
      .defaultSuccessUrl("/dashboard", true)
      .permitAll()
    );
  }

  private void configureLogout (HttpSecurity http) throws Exception {
    http.logout(logout -> logout
      .logoutSuccessUrl("/")
      .permitAll()
    );
  }

  private void configureH2Console (HttpSecurity http) throws Exception {
    // Bypass CSRF tokens for H2 console actions and allow browser to render
    // H2's internal frame layout. The former is safe for local development;
    // the latter is protected by a very restrictive CORS setting.
    http
      .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
      .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
  }
}
