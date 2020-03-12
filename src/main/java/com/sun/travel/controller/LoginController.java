package com.sun.travel.controller;

import com.alibaba.fastjson.JSON;
import com.sun.travel.constant.UserContextConstant;
import com.sun.travel.domain.usercontext.FrontUserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @class: LoginController <br>
 * @author: sun <br>
 * @date: 2020-03-12 16:11
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation("登录")
    public void login(HttpSession httpSession) {
        FrontUserInfo frontUserInfo = new FrontUserInfo();
        frontUserInfo.setUserName("孙庆贺");
        frontUserInfo.setUserPhone("1112312");
        httpSession.setAttribute(UserContextConstant.FRONT_USER_SESSION_NAME, JSON.toJSON(frontUserInfo));
    }
}
