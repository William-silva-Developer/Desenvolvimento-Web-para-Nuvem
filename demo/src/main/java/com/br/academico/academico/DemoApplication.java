package com.br.academico.academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = {"com.br.academico.academico.domain.repository"})
@EntityScan(basePackages = {"com.br.academico.academico.domain.model"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
