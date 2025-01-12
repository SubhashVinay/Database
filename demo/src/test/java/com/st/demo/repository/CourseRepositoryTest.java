package com.st.demo.repository;

import com.st.demo.DemoApplication;
import com.st.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {

	private static Logger logger= LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	CourseRepository courseRepository;

	@Test
	void findByIdTest() {
		Course course=courseRepository.findById(10001);
		assertEquals("JPA in 50 Steps!",course.getName());
	}

	@Test
	@DirtiesContext
	void deleteByIdTest() {
		courseRepository.deleteById(10002);
		assertNull(courseRepository.findById(10002));
	}

	@Test
	@DirtiesContext
	void saveTest() {
		Course course=courseRepository.findById(10001);
		assertEquals("JPA in 50 Steps!",course.getName());

		course.setName("JPA in 50 Steps - Updated!");
		courseRepository.save(course);

		Course course1=courseRepository.findById(10001);
		assertEquals("JPA in 50 Steps - Updated!",course1.getName());

	}

	@DirtiesContext
	@Test
	void playWithEntityManagerTest(){
		courseRepository.playWithEntityManager();
	}

}
