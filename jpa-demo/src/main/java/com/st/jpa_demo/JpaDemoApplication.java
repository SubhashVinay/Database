package com.st.jpa_demo;

import com.st.jpa_demo.bean.Person;
import com.st.jpa_demo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private static Logger logger= LoggerFactory.getLogger(JpaDemoApplication.class);

	@Autowired
	private PersonJpaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User id 10001 -> {}",repo.findById(10001));
		logger.info("Inserting Aadhya -> {} ", repo.insert(new Person("Aadhya","Noida", LocalDateTime.now())));
		logger.info("Updating 10003 -> {} ", repo.update(new Person(10003,"Manoj","Garsanda", LocalDateTime.now())));
		logger.info("All users -> {}", repo.findAll());
		repo.delete(10002);
	}

}
