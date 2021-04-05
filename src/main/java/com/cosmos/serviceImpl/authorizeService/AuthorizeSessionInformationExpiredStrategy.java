package com.cosmos.serviceImpl.authorizeService;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

@Component
public class AuthorizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {//会话信息过期策略
    //当账号异地登录导致被挤下线时也要返回给前端json格式的数据，比如提示"账号下线"、"您的账号在异地登录，是否是您自己操作"或者"您的账号在异地登录,可能由于密码泄露，建议修改密码"等。
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
//        JsonResult result = ResultTool.fail(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
//        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
//        httpServletResponse.setContentType("text/json;charset=utf-8");
//        httpServletResponse.getWriter().write(JSON.toJSONString(result));
        System.out.println("您的账号在异地登录");
    }
}
