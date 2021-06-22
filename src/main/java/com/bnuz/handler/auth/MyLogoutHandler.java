package com.bnuz.handler.auth;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chanchitin
 * @date 2021/5/5
 */
@Component
public class MyLogoutHandler extends JSONAuthentication implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String headerToken = request.getHeader("Authorization");
        System.out.println("logout header Token = " + headerToken);
        if(!StrUtil.isEmpty(headerToken)){
            String token = headerToken.replace("Bearer","").trim();
            System.out.println("authentication =" + authentication);
            SecurityContextHolder.clearContext();
        }
    }
}
