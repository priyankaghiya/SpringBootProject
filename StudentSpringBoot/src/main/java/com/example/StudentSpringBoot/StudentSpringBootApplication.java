package com.example.StudentSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSpringBootApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(StudentSpringBootApplication.class, args);
		System.out.println("MAIN IS CALLED.......");
	}

}
