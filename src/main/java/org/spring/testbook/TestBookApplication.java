package org.spring.testbook;

import org.mybatis.spring.annotation.MapperScan;
import org.spring.testbook.Mapper.BookMapper;
import org.spring.testbook.config.AppConfig;
import org.spring.testbook.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan("org.spring.testbook.Mapper")
public class TestBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBookApplication.class, args);
    }

}
