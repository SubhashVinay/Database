package com.st.jpa_demo.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "person")
@NamedQuery(name = "find_all_persons",query = "Select p from Person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private LocalDateTime birthDate;

    public Person() {
    }
    public Person( String name, String location, LocalDateTime birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }
    public Person(int id, String name, String location, LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
