package com.model;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{

    private long id;
    private String name;
    private int age;
    private String occupation;


    public Employee(long id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (!(o instanceof Employee))
           throw new IllegalArgumentException("Illegal Employee object");
        return this.getName().compareTo(o.getName());
    }
}
