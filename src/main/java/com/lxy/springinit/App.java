package com.lxy.springinit;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        Student student = (Student) context.getBean("st",Student.class);
        student.setName("大明");
        System.out.println(student.getName()+"start");
        student.doHomeWork();
        context.close();
    }
}
