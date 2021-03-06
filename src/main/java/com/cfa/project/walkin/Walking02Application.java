package com.cfa.project.walkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.cfa.project.walkin", "com.cfa.projects.walking.custom.repositories",
		"com.cfa.project.walkin.controllers", "com.cfa.project.walkin.models",
		"com.cfa.projects.walkin.utils.converters" })
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.cfa.project.walkin.repositories"})
public class Walking02Application {

	public static void main(String[] args) {
		SpringApplication.run(Walking02Application.class, args);
	}
}
