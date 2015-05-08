package com.thoughtworks.fam;

import com.thoughtworks.fam.dao.User;
import com.thoughtworks.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("----------------");
        User user = userService.findByUserName("lwzhang");
        System.out.println(user.getAsserts());
        System.out.println("----------------");
    }
}
