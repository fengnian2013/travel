package com.sun.travel.controller;


import com.alibaba.fastjson.JSON;
import com.sun.travel.constant.UserContextConstant;
import com.sun.travel.domain.Result;
import com.sun.travel.domain.usercontext.FrontUserContext;
import com.sun.travel.domain.usercontext.FrontUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sun
 * @since 2020-03-12
 */
@RestController
@Api("banner接口")
@RequestMapping("/banner")
public class BannerController {





    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ApiOperation("获取登录用户")
    public Result<FrontUserInfo> getUser() {
        FrontUserInfo frontUserInfo = FrontUserContext.get();
        return Result.success(frontUserInfo);
    }


}
