package ru.itis.security.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.security.authentication.JwtAuthentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");

        //JwtTokenAuthentication authentication = new JwtTokenAuthentication(token);

        if (token == null){
            JwtAuthentication authentication = new JwtAuthentication(null);
            authentication.setAuthenticated(false);
        }else {
            JwtAuthentication authentication = new JwtAuthentication(token);
            authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
