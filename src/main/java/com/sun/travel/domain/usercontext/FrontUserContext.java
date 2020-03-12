package com.sun.travel.domain.usercontext;

import lombok.Data;

/** 登录用户上下文
 * @class: FrontUserContext <br>
 * @author: sun <br>
 * @date: 2020-03-12 14:11
 */
@Data
public class FrontUserContext {

    private static ThreadLocal<FrontUserInfo> local=new ThreadLocal<>();

    public static FrontUserInfo get(){
        return local.get();
    }

    public static void set(FrontUserInfo frontUserInfo){
        local.set(frontUserInfo);
    }
}
