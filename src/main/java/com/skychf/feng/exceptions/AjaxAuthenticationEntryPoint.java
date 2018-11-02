package com.skychf.feng.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skychf.feng.api.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e)
            throws IOException, ServletException {
        httpServletResponse.getWriter().write(
                new ObjectMapper().writeValueAsString(Result.error("您没有登录", 401))
        );
    }
}
