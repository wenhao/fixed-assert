package com.thoughtworks.fam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationRunner.class, args);
    }

}
