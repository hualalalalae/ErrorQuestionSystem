package com.example.flawsweeper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.flawsweeper.Mapper")
@SpringBootApplication
public class FlawSweeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlawSweeperApplication.class, args);
    }

}
