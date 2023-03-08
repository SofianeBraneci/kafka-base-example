package com.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.stream.IntStream;

@SpringBootApplication
public class KafkaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringApplication.class, args);
	}

	// IT'S FAST!!!
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args ->{
			IntStream.rangeClosed(1, 100).forEach(i -> kafkaTemplate.send("topic", "Hello Kafka " + i));
		};
	}
}
