package com.finalproject.sistemaTurnosClinicaDental.security.config;

import com.finalproject.sistemaTurnosClinicaDental.security.UsuarioAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioAppService usuarioAppService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            //.antMatchers("/user/**").hasAnyAuthority("USER")
            //.antMatchers("/admin/**").hasAnyAuthority("ADMIN")

            .antMatchers("/pacientes/**", "/odontologos/**").hasRole("ADMIN")
            .antMatchers("/turnos/**").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            .and().csrf().ignoringAntMatchers("/h2-console/**")
            .and().headers().frameOptions().sameOrigin()
            .and().formLogin().permitAll()
            .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioAppService);
        return provider;
    }
}
