package com.sun.travel.interceptor;

import com.sun.travel.interceptor.FrontUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @class: InterceptorConfig <br>
 * @author: sun <br>
 * @date: 2020-03-12 14:34
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private FrontUserInterceptor frontUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //加入顺序及执行顺序
        registry.addInterceptor(frontUserInterceptor).addPathPatterns("/**").excludePathPatterns("/login")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
