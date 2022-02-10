package com.example.springaopaamir;

import com.example.springaopaamir.aop.AppConfig;
import com.example.springaopaamir.aop.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringAopAamirApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopAamirApplication.class, args);
       // SpringApplication.run(SpringAopAamirApplication.class, args);
       // AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       // Student student = context.getBean("student", Student.class);
       // student.study();

    }

}
