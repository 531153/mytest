package com.lxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lxy
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("================启动成功！！！！=============");
        SpringApplication.run(com.lxy.Application.class, args);
    }
}
