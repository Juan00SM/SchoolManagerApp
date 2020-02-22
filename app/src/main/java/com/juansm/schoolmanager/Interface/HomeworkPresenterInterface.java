package com.juansm.schoolmanager.Interface;

import com.juansm.schoolmanager.Model.Entities.Homework;

import java.util.List;

public interface HomeworkPresenterInterface {

    boolean insertNewHomework(Homework homework);
    boolean removeHomework(Long id);
    boolean removeHomework(Homework homework);
    boolean modifyExitHomework(Homework homework);
    List<Homework> readHomeworks();
    List<Homework> readHomeworksReduced();
}
