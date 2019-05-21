package com.academy.hms.hms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    @Configuration
    public static class Admin extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception{

            http.authorizeRequests()
                    .antMatchers("/css/**","/img/**","/js/**","/fonts/**")
                    .permitAll()
                    .anyRequest().permitAll();

//            http.authorizeRequests()
//                    .antMatchers("/admin/**").hasRole("ADMIN");
        }

        @Override
        public void configure(WebSecurity web) throws Exception{
            web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
        }
    }
}
