package com.lxy.springinit;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@Aspect
public class CheckNowTime {
    @Pointcut("execution(* demo.Student.doHomeWork(..))")
    private void pointCut(){

    }
    @Before("pointCut()")
    public void beforDoHomework() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("do before:"+df.format(ldt));
    }
}
