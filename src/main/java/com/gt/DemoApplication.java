package com.gt;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 	SpringBoot 通常有一个 *Application 的入口类，入口类里有一个 main 方法，这个 main 方法就是一个标准的 Java 应用的入口方法
 *
 * 1.@SpringBootApplication 是 SpringBoot 项目的核心注解，主要目的是开启自动配置 它主要组合了
 * 		@Configuration、 @EnableAutoConfiguration、 @ComponentScan 如果不使用 @SpringBootApplication 注解可以直接在类上
 * 	添加 @Configuration、@EnableAutoConfiguration  其中 @EnableAutoConfiguration 注解是让 SpringBoot 根据类路径下的 jar
 * 	包依赖为当前项目进行自动配置  例如添加了 spring-boot-start-web 依赖，会自动添加 Tomcat 和 Spring MVC 的依赖，那么 SpringBoot
 * 	会对 Tomcat 和 SpringMVC 进行自动配置
 * 2.main 方法 这是一个标准的 java 应用的 main 方法，主要作用是作为项目启动的入口
 * 3.
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public EmbeddedServletContainerFactory servletContainer(){
//		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(){
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection securityCollection = new SecurityCollection();
//				securityCollection.addPattern("/*");
//				securityConstraint.addCollection(securityCollection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//		tomcat.addAdditionalTomcatConnectors(httpConnector());
//		return tomcat;
//	}
//
//	@Bean
//	public Connector httpConnector(){
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setScheme("8080");
//		connector.setSecure(false);
//		connector.setRedirectPort(8443);
//		return connector;
//	}
}
