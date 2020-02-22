package com.juansm.schoolmanager.Interface;

import com.juansm.schoolmanager.Model.Entities.Student;

import java.util.List;

public interface StudentPresenterInterface {

    Long insertNewStudent(Student student);
    boolean removeStudent(Long id);
    boolean removeStudent(Student student);
    boolean modifyExitStudent(Student student);
    List<Student> readStudents();
    List<Student> readStudentsReduced();
}
