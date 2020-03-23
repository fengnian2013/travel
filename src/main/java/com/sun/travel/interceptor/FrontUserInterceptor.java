package com.sun.travel.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.travel.annotation.AuthAccess;
import com.sun.travel.annotation.BackAuthAccess;
import com.sun.travel.constant.UserContextConstant;
import com.sun.travel.domain.Result;
import com.sun.travel.domain.usercontext.FrontUserContext;
import com.sun.travel.domain.usercontext.FrontUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
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
        HandlerMethod method = (HandlerMethod) handler;
        AuthAccess methodAnnotation = method.getMethodAnnotation(AuthAccess.class);
        if (null != methodAnnotation) {
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
        BackAuthAccess backAuthAccess = method.getMethodAnnotation(BackAuthAccess.class);
        if (null != backAuthAccess) {
            Object attribute = request.getSession().getAttribute(UserContextConstant.BACK_USER_SESSION_NAME);
            if (null == attribute) {
                this.failResponse(response);
                return false;
            }
            FrontUserInfo frontUserInfo =
                    JSON.parseObject(((JSONObject) attribute).toString(), FrontUserInfo.class);
            FrontUserContext.set(frontUserInfo);
            return true;
        }
        return true;
    }

    private void failResponse(HttpServletResponse response) throws IOException {
        Result<String> result = Result.fail(UserContextConstant.HTTP_AUTH_FAIL, UserContextConstant.HTTP_AUTH_FAIL_MSG);
        response.getWriter().write(JSON.toJSONString(result));
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().flush();
    }
}
