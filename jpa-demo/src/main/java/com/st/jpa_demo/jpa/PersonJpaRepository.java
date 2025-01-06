package com.st.jpa_demo.jpa;

import com.st.jpa_demo.bean.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons",Person.class);
        return namedQuery.getResultList();
        //return entityManager.find(Person.class,id);
    }

    public Person findById(int id){

        return entityManager.find(Person.class,id);
    }

    public Person update(Person person){
       return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void delete(int id){
        Person person=findById(id);
        entityManager.remove(person);
    }
}
