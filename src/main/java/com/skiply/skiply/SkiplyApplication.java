package com.skiply.skiply;

import com.skiply.skiply.Exception.ControllerExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAspectJAutoProxy
@Import(ControllerExceptionHandler.class)
public class SkiplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkiplyApplication.class, args);
	}

}

