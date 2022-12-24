package com.RedCarpetUpAssignment.SpringBootHelloWorld;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SpringBootHelloWorld {
	@GetMapping("/springBootHelloWorld")
	private String springBootHelloWorld() {
		return "Hello World";
	}
}
