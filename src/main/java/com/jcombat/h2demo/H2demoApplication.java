package com.jcombat.h2demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jcombat.repository.StudentRepository;

@SpringBootApplication
@EntityScan("com.jcombat.entity")
@EnableJpaRepositories("com.jcombat.repository")
public class H2demoApplication implements CommandLineRunner {

	// mvn spring-boot:run
	private Logger LOG = LoggerFactory.getLogger("H2demoApplication");
	
	StudentRepository studentRepository;
	
	@Autowired
	public H2demoApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(H2demoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Student count in DB: {}", studentRepository.count());
	}
}