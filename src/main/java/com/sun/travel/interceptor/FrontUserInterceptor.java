package com.sun.travel.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.travel.constant.UserContextConstant;
import com.sun.travel.domain.Result;
import com.sun.travel.domain.usercontext.FrontUserContext;
import com.sun.travel.domain.usercontext.FrontUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截器
 *
 * @class: FrontUserInterceptor <br>
 * @author: sun <br>
 * @date: 2020-03-12 14:12
 */
@Slf4j
@Component
public class FrontUserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Object attribute = request.getSession().getAttribute(UserContextConstant.FRONT_USER_SESSION_NAME);
        if (null == attribute) {
            this.failResponse(response);
            return false;
        }
        FrontUserInfo frontUserInfo =
                JSON.parseObject(((JSONObject) attribute).toString(), FrontUserInfo.class);
        FrontUserContext.set(frontUserInfo);
        return true;
    }

    private void failResponse(HttpServletResponse response) throws IOException {
        Result<String> result = Result.fail(UserContextConstant.HTTP_AUTH_FAIL, UserContextConstant.HTTP_AUTH_FAIL_MSG);
        response.getWriter().write(JSON.toJSONString(result));
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().flush();
    }
}
