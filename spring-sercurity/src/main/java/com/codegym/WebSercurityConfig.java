package com.codegym;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder)throws Exception{
        managerBuilder.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("12345").roles("ADMIN");
    }
    @Override
    public void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/user**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
