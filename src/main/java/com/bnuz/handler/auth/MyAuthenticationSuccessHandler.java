package com.bnuz.handler.auth;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bnuz.common.Result;
import com.bnuz.common.ResultCode;
import com.bnuz.mapper.UserMapper;
import com.bnuz.pojo.User;
import com.bnuz.service.UserService;
import com.bnuz.service.impl.UserAuth;
import com.bnuz.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Chanchitin
 * @date 2021/5/4
 * 用户登陆成功处理器
 */
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserAuth principal = (UserAuth)authentication.getPrincipal();
        Result result = Result.ok().message(ResultCode.VERIFY_SUCCESS.getMessage()).data("user",principal);
        this.WriteJSON(request,response,result);

        Integer userId = principal.getUser().getId();
        //更新用户登录ip地址，最新登录时间
        String ipAddress = IpUtil.getIp(request);
        String ipPosition = IpUtil.getIpSource(ipAddress);
        //mybatisplus不支持多主键
            UpdateWrapper<User> wrapper = new UpdateWrapper<>();
            wrapper.set("ip_address",ipAddress)
                    .set("ip_position",ipPosition)
                    .set("last_login_time",new Date())
                .eq("id",userId);
            userService.update(wrapper);



//        response.setContentType("text/json;charset=utf-8");
//        //springboot jackson将类或对象转为json字符串
//        response.getWriter().write(new ObjectMapper().writeValueAsString(result));

    }
}
