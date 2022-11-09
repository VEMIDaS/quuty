/*
 * Copyright(c) 2022 mirelplatform.
 */
package jp.vemi.framework.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MirelSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  MirelUserDetailsService userAccountService;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        // Must be authenticated.
        .authorizeRequests()
        .mvcMatchers("/auth/**").permitAll() // auth
        .anyRequest().authenticated()
        .and()
        // Login form.
        .formLogin()
        .loginProcessingUrl("/auth/login").permitAll()
        .usernameParameter("userCd")
        .passwordParameter("password")
        .and()
        // Logout.
        .logout()
        .logoutUrl("/auth/logout");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userAccountService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }
}
