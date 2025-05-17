package com.architecturemvc.Login.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecutiryConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login", "/cadastro").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form ->{
                    form
                            .loginPage("/login")
                            .defaultSuccessUrl("/tarefas", true)
                            .permitAll();
                })
                .oauth2Login(oauth ->{
                    oauth
                            .loginPage("/login")
                            .defaultSuccessUrl("/tarefas", true);
                })
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login")
                                .permitAll()
                )

                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
