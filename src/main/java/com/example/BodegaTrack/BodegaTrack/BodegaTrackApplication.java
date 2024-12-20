package com.example.BodegaTrack.BodegaTrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class BodegaTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodegaTrackApplication.class, args);
	}

}
