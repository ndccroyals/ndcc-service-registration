package com.ndcc.registration.playerRegistration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages="com.ndcc.registration.playerRegistration")

public class PlayerRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerRegistrationApplication.class, args);
	}

}
