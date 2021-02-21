package com.example.springbootdocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

    public static final Logger logger = LoggerFactory.getLogger(SpringBootDockerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World!";
    }

    @Bean
    public CommandLineRunner runner(Environment env) {
        return args -> {
            logger.info("Running on {} version {} file ({})",
                    env.getProperty("os.name"),
                    env.getProperty("os.version"),
                    env.getProperty("os.arch"));
            logger.info("User {}",
                    env.getProperty("user.name"));
        };
    }
}
