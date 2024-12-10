package org.example.springjdbcexamples.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.springjdbcexamples.exception.Code;
import org.example.springjdbcexamples.exception.XException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getHeader("uid") == null && request.getHeader("role") == null) {
            throw XException.builder().code(Code.UNAUTHORIZED).build();
        }
        String uid = request.getHeader("uid");
        String role = request.getHeader("role");
        log.debug("{}",uid);
        request.setAttribute("uid",uid);
        request.setAttribute("role",role);
        return true;
    }
}
