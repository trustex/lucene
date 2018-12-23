package com.xywy.lucene;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.xywy.lucene.mapper")
public class SearchApp {
    //项目启动类
    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class,args);
    }
}
