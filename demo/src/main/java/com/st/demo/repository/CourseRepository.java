package com.st.demo.repository;

import com.st.demo.entity.Course;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private static final Logger logger= LoggerFactory.getLogger(CourseRepository.class);

    @Autowired
    EntityManager em;

    public Course findById(int id){
        return em.find(Course.class,id);
    }

    public Course save(Course course){
        if(course.getId() == null){
            em.persist(course);
        }else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(int id){
        Course course=findById(id);
        em.remove(course);
    }

    public void playWithEntityManager(){

        Course course1=new Course("GCP By Subhash!");
        em.persist(course1);
        Course course2=new Course("Angular JS in 100 Steps!");
        em.persist(course2);

        em.flush();

        course1.setName("GCP By Subhash! - Updated!");
        course2.setName("Angular JS in 100 Steps! - Updated!");

        em.refresh(course1);
        em.flush();
    }
}
