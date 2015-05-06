package com.thoughtworks.fam;

import com.thoughtworks.fam.dao.User;
import com.thoughtworks.fam.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(new User("admin", "P@ss123456"));
        System.out.println("----------------");
        System.out.println(userRepository.findByUserName("admin"));
        System.out.println("----------------");
    }
}
