package org.spring.testbook.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }


    @Bean
    public SecurityFilterChain configure(HttpSecurity http,
                                         PersistentTokenRepository tokenRepository) throws Exception {
        return  http
                .authorizeHttpRequests(authorizeRequests ->{
                    authorizeRequests.requestMatchers("/static/**").permitAll();
                    authorizeRequests.anyRequest().authenticated();
                })
                .formLogin(conf->{
                    conf.loginPage("/login");
                    conf.loginProcessingUrl("/doLogin");
                    conf.defaultSuccessUrl("/");
                    conf.permitAll();
                })
                .logout(conf->{
                    conf.logoutUrl("/doLogout");
                    conf.logoutSuccessUrl("/login");
                    conf.permitAll();
                })
                .rememberMe(conf->{
                    conf.tokenRepository(tokenRepository);
                    conf.tokenValiditySeconds(3600 * 24 * 7);
                })
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
