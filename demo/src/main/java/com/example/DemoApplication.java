package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.querydsl.sql.Configuration;
import com.querydsl.sql.HSQLDBTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    DataSource dataSource;

    @Bean
    Configuration configuration() {
        SQLTemplates templates = new HSQLDBTemplates();
        return new Configuration(templates);
    }

    @Bean
    SQLQueryFactory sqlQueryFactory() {
        return new SQLQueryFactory(configuration(), dataSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        
    }

}
