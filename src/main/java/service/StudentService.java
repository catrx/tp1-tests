package service;


import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Student> findAll(String name);

    Student getStudent(String id);
}
