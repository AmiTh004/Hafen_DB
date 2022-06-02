package com.example.Hafen_DB;

import com.example.Hafen_DB.controller.DBController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HafenDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HafenDbApplication.class, args);
		new DBController();
	}

}
