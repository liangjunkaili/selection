package com.course.selection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.course.selection.dao")
public class SelectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelectionApplication.class, args);
	}

}

