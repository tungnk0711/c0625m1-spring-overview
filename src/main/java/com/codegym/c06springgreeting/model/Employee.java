package com.codegym.c06springgreeting.model;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private Long age;

    public Employee(int id, String name, String dept, Long age) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    public Employee() {
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                '}';
    }
}
