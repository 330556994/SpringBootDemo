package com.gt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Administrator on 2017/3/11.
 * 这个类没有任何特别的地方 只是一个普通的 Spring 的配置类  这里我们配置了一个 jsp 的 viewResolver  用来映射路径和实际页面的位置，
 * 其中 @EnableWebMvc 注解开启一些默认配置，如一些 ViewResolver 和 MessageConverter
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.gt")
public class MyMvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}
