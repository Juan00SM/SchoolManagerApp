package com.juansm.schoolmanager.Interface;

import com.juansm.schoolmanager.Model.Entities.Teacher;

import java.util.List;

public interface TeacherPresenterInterface {

    boolean insertNewTeacher(Teacher teacher);
    boolean removeTeacher(Long id);
    boolean removeTeacher(Teacher teacher);
    boolean modifyExitTeacher(Teacher teacher);
    List<Teacher> readTeachers();
    List<Teacher> readTeachersReduced();
}
