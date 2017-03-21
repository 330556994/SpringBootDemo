package com.gt.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by Administrator on 2017/3/11.
 *      WebApplicationInitializer 类是 Spring 提供用来配置 Servlet3.0+ 配置的接口，从而实现了代替 Web.xml 的位置，实现此接口将会自动
 *  被 SpringServletContainerInitializer (用来启动 Servlet3.0 容器)获取到
 *
 *
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        //新建 WebApplicationContext 注册配置类 并将其 和当前 servletContext 关联
        ctx.setServletContext(servletContext);
        //注册 Spring MVC 的 DispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

    }
}
