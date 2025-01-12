package com.st.demo.repository;

import com.st.demo.DemoApplication;
import com.st.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
class JPQLTest {

	private static Logger logger= LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	EntityManager em;

	@Test
	void findAllTest() {
		Query query=em.createNamedQuery("select c from Course c");
		List resultList=query.getResultList();
		logger.info("select c from Course c -> {}",resultList);
//		Course course=courseRepository.findById(10001);
//		assertEquals("JPA in 50 Steps!",course.getName());
	}
	@Test
	void findByIdTypedTest() {
//		Course course=courseRepository.findById(10001);
//		assertEquals("JPA in 50 Steps!",course.getName());
		TypedQuery<Course> query=em.createNamedQuery("select c from Course c",Course.class);
		List<Course> resultList=query.getResultList();
		logger.info("select c from Course c -> {}",resultList);
	}

}
