package br.ifsp.edu.prw3.mechanics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode =
		EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class MechanicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MechanicsApplication.class, args);
	}

}
