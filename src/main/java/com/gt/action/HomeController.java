package com.gt.action;

import com.gt.entities.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 *      SpringBoot 的 Web 开发支持
 *  SpringBoot 提供了 spring-boot-starter-web 为Web开发予以支持， spring-boot-starter-web为我们提供了嵌入式的 Tomcat 以及 Spring MVC
 *  的依赖。而 Web 相关的自动配置存储在 spring-boot-autoconfigure.jar 的 org.springframework.boot.autoconfigure.web 下
 */

@Controller
@RequestMapping("/")
public class HomeController {
    //在 Spring Boot 中 只需要在 application.properties 中定义属性，直接使用 @Value() 注解注入即可
    @Value("${gongtao.name}")
    private String gName;

    @Value("${gongtao.age}")
    private int gAge;

    @RequestMapping("/home")
    public String hello(Model model){
        Person person = new Person("gongtao",10);
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("习近平",100));
        people.add(new Person("李克强",100));
        people.add(new Person("刘云山",100));
        people.add(new Person("张德江",100));
        model.addAttribute("people",people);
         model.addAttribute("person",person);
//        return "我的姓名是:"+gName+",我的年龄是："+gAge;
        return "index";
    }


    @RequestMapping(value = "/image/{grade}",method= RequestMethod.GET)
    public String action(Model model, @PathVariable("grade") int grade){
        Person person = new Person("gongtao",grade);
        model.addAttribute("person",person);
        return "image";
    }

}
