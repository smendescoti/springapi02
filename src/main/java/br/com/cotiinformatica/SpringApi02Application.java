package br.com.cotiinformatica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.cotiinformatica" })
public class SpringApi02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringApi02Application.class, args);
	}

}
