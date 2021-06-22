package com.bnuz.handler.auth;

import com.bnuz.common.Result;
import com.bnuz.common.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chanchitin
 * @date 2021/5/5
 * 权限不足
 */
@Component
public class MyAccessDeniedHandler extends JSONAuthentication implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        Result result = Result.error().message(ResultCode.NOT_ENOUGH_PERMISSION.getMessage()).code(ResultCode.NOT_ENOUGH_PERMISSION.getCode());
        this.WriteJSON(request,response,result);
    }
}
