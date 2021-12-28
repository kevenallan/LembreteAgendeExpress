package br.edu.ifpb.agendeexpress.lembrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LembreteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LembreteApplication.class, args);
	}

}
