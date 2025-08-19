package com.restapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// to handle exception for bad data, eg. if asked for student id 100, which is not available, it should throw an error
/* Development Process
Step 1: Create a custom error response class

Step 2: Create a custom exception class

Step 3: Update the REST service to throw exception if student not found

Step 4: Add an exception handler using @ExceptionHandler

 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
