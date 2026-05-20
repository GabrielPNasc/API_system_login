package com.pires.api_sistemalogin;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiSistemaLoginApplication {

	public static void main(String[] args) {
		//usando Dotenv para ler os dados do .Env
		Dotenv dotenv = Dotenv.load();

		System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(ApiSistemaLoginApplication.class, args);
	}

}
