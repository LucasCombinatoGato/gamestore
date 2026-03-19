package com.lucascombinatogato.gamestore;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GamestoreApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

		String dbUrl = dotenv.get("DB_URL");
		String dbUser = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		if (dbUrl != null) {
			System.setProperty("DB_URL", dbUrl);
		}
		if (dbUser != null) {
			System.setProperty("DB_USERNAME", dbUser);
		}
		if (dbPassword != null) {
			System.setProperty("DB_PASSWORD", dbPassword);
		}

		System.out.println("Using DB_URL=" + dbUrl);
		System.out.println("Using DB_USERNAME=" + dbUser);

		SpringApplication.run(GamestoreApplication.class, args);
	}

}
