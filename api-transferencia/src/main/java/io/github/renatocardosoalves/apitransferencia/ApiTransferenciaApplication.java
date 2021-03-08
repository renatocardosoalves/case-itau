package io.github.renatocardosoalves.apitransferencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiTransferenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTransferenciaApplication.class, args);
	}

}
