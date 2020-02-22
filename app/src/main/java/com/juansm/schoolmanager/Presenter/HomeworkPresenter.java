package com.juansm.schoolmanager.Presenter;

import com.juansm.schoolmanager.Interface.HomeworkPresenterInterface;
import com.juansm.schoolmanager.Model.DAOs.HomeworkDAO;
import com.juansm.schoolmanager.Model.DAOs.TeacherDAO;
import com.juansm.schoolmanager.Model.Entities.Homework;
import com.juansm.schoolmanager.Model.Entities.Teacher;

import java.util.List;

public class HomeworkPresenter implements HomeworkPresenterInterface {

    private static HomeworkPresenter presenter;

    public static HomeworkPresenter getInstance(){
        if (presenter==null){
            presenter = new HomeworkPresenter();
        }
        return presenter;
    }

    private HomeworkPresenter(){

    }

    public boolean insertNewHomework(Homework homework){
        HomeworkDAO dao = HomeworkDAO.getInstance();
        if (dao.insertHomework(homework)){
            return true;
        }else{
            return false;
        }
    }

    public boolean removeHomework(Long id){
        HomeworkDAO dao = HomeworkDAO.getInstance();
        if (dao.removeHomework(id)){
            return true;
        }else{
            return false;
        }
    }

    public boolean removeHomework(Homework homework){
        HomeworkDAO dao = HomeworkDAO.getInstance();
        if (dao.removeHomework(homework.getId())){
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyExitHomework(Homework homework){
        HomeworkDAO dao = HomeworkDAO.getInstance();
        if (dao.modifyHomework(homework)){
            return true;
        }else{
            return false;
        }
    }

    public List<Homework> readHomeworks(){
        HomeworkDAO dao = HomeworkDAO.getInstance();

        return dao.getHomeworks();
    }

    public List<Homework> readHomeworksReduced(){
        HomeworkDAO dao = HomeworkDAO.getInstance();

        return dao.getHomeworksReduced();
    }
}
