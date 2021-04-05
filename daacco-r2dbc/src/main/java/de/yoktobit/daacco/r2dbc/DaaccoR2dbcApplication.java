package de.yoktobit.daacco.r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DaaccoR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaaccoR2dbcApplication.class, args);
	}

}
