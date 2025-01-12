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
class NativeQueryTest {

	private static Logger logger= LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	EntityManager em;

	@Test
	void findAllTest() {
		Query query=em.createNativeQuery("select * from course");
		List resultList=query.getResultList();
		logger.info("select c from Course c -> {}",resultList);
	}

	@Test
	void nativeQueriesWithPArameterTest() {
		Query query=em.createNativeQuery("select * from course where id= ?",Course.class);
		query.setParameter(1,10001);
		List resultList=query.getResultList();
		logger.info("select c from Course c -> {}",resultList);
	}


}
