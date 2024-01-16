package org.example.md3_sec1_jsp_servlet_crud.ra_crud.test;


import org.example.md3_sec1_jsp_servlet_crud.ra_crud.model.Student;

public class Main {
     public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(2L,"Hồ Xuân Hùng",30,true);
        System.out.println(s1.getName());
        System.out.println(s2.getName());
    }
}
