package ru.itis.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.itis.security.filters.JwtFilter;
import ru.itis.security.provider.JwtAuthenticationProvider;


@ComponentScan("ru.itis")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationProvider jwtTokenAuthenticationProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();

        http
                .addFilterBefore(jwtFilter, BasicAuthenticationFilter.class)
                .antMatcher("/**")
                .authorizeRequests()
                //.antMatchers("/users/**").hasAuthority("USER")
                //.antMatchers("/refresh").hasAuthority("USER")
                .antMatchers("/requests/**").permitAll()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/companies/**").authenticated()
                .antMatchers("/recalls/**").authenticated()
                .antMatchers("/vacancies/**").authenticated()
                .antMatchers("/registrate").permitAll()
                .antMatchers("/login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtTokenAuthenticationProvider);
    }
}
