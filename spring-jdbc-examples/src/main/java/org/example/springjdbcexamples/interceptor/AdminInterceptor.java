package org.example.springjdbcexamples.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.springjdbcexamples.dox.User;
import org.example.springjdbcexamples.exception.Code;
import org.example.springjdbcexamples.exception.XException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = request.getHeader("role");
        if(!role.equals(User.ADMIN) ) {
            throw XException.builder().code(Code.FORBIDDEN).build();
        }
        return true;
    }
}
