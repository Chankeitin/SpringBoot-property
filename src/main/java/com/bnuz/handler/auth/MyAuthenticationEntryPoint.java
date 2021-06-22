package com.bnuz.handler.auth;


import com.bnuz.common.Result;
import com.bnuz.common.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chanchitin
 * @date 2021/5/5
 * 用户未登录处理器
 */
@Component
public class MyAuthenticationEntryPoint extends JSONAuthentication implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Result result = Result.error().message(ResultCode.NOT_LOGIN.getMessage());
        this.WriteJSON(request,response,result);
    }
}
