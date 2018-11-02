package com.skychf.feng.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skychf.feng.api.Result;
import com.skychf.feng.entity.User;
import com.skychf.feng.utils.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 用户登录成功
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        String jwtToken = JwtTokenUtil.generateToken(user.getUsername(), 30000, "_secret");
        httpServletResponse.getWriter().write(
                new ObjectMapper().writeValueAsString(Result.success("登录成功", jwtToken))
        );
    }
}
