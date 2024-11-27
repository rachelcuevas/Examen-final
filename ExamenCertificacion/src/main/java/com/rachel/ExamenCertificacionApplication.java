package com.rachel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = "com.rachel")
@EnableJpaRepositories("com.rachel.repositories")
@EntityScan("com.rachel.models")
public class ExamenCertificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenCertificacionApplication.class, args);
	}

	
	    
	}

