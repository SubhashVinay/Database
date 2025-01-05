package com.st.database_demo;

import com.st.database_demo.bean.Person;
import com.st.database_demo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private static Logger logger= LoggerFactory.getLogger(SpringJdbcDemoApplication.class);

	@Autowired
	private PersonJdbcDao dao;

	public static void main(String[] args) {

		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}",dao.findById(10001));
		logger.info("Deleting ID 10002 -> Number of rows deleted is {}",dao.deleteById(10002));
		logger.info("Inserting 10004 -> {} ", dao.insert(new Person(10004,"Aadhya","Noida", LocalDateTime.now())));
		logger.info("Updating 10003 -> {} ", dao.update(new Person(10003,"Manoj","Garsanda", LocalDateTime.now())));
	}
}
