package com.bnuz.handler.auth;

import com.bnuz.common.Result;
import com.bnuz.common.ResultCode;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Chanchitin
 * @date 2021/5/6
 * 登录被挤下线处理
 */
@Component
public class MyExpiredSessionStrategy extends JSONAuthentication implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent Event) throws IOException, ServletException {
        Result result = Result.error().message(ResultCode.USER_ACCOUNT_USE_BY_OTHERS.getMessage()).code(ResultCode.USER_ACCOUNT_USE_BY_OTHERS.getCode());
        this.WriteJSON(Event.getRequest(),Event.getResponse(),result);
    }
}
