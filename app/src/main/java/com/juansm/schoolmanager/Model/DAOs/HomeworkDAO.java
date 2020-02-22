package com.juansm.schoolmanager.Model.DAOs;

import com.juansm.schoolmanager.Model.Entities.Homework;

import java.util.List;

public class HomeworkDAO {
    private static HomeworkDAO dao;

    public static HomeworkDAO getInstance(){
        if (dao==null){
            dao = new HomeworkDAO();
        }
        return dao;
    }

    public HomeworkDAO() {
    }

    public boolean insertHomework(Homework homework) {
        return false;
    }

    public boolean removeHomework(Long id) {
        return false;
    }

    public boolean modifyHomework(Homework homework) {
        return false;
    }

    public List<Homework> getHomeworks() {
        return null;
    }

    public List<Homework> getHomeworksReduced() {
        return null;
    }
}
