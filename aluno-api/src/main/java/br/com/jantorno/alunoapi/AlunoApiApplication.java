package br.com.jantorno.alunoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlunoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApiApplication.class, args);
	}

/*
@PostConstruct
void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
}
*/

}