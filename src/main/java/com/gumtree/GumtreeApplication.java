package com.gumtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource(value = "classpath:/config/config.properties")
public class GumtreeApplication {
    public static void main(String[] args) {
    	SpringApplication.run(GumtreeApplication.class, args);
    }
}
