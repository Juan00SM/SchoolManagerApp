package com.juansm.schoolmanager.Interface;

import com.juansm.schoolmanager.Model.Entities.Subject;

import java.util.List;

public interface SubjectPresenterInterface {

    boolean insertNewSubject(Subject subject);
    boolean removeSubject(Long id);
    boolean removeSubject(Subject subject);
    boolean modifyExitSubject(Subject subject);
    List<Subject> readSubjects();

}
