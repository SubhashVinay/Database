package com.st.demo;

import com.st.demo.entity.Course;
import com.st.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

	private static Logger logger= LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course=courseRepository.findById(10001);
//		courseRepository.deleteById(10002);
//		logger.info("Course Details 10001 ->"+course);
//		courseRepository.save(new Course("Microservices"));
		courseRepository.playWithEntityManager();
	}
}
