package org.example.md3_sec1_jsp_servlet_crud.ra_crud.model;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor // constructor không tham số
//@AllArgsConstructor // constructor full tham số
//@Data // getter, setter
public class Student {
    private Long id;
    private  String name;
    private  Integer age;
    private  Boolean sex;

    public Student() {
    }

    public Student(Long id, String name, Integer age, Boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
