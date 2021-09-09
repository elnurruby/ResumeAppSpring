package com.company;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.support.*;

@SpringBootApplication
public class ResumeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ResumeApplication.class, args);
	}
}
