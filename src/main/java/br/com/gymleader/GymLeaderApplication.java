package br.com.gymleader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GymLeaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymLeaderApplication.class, args);
	}

}
