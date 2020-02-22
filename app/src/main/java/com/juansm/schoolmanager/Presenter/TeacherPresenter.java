package com.juansm.schoolmanager.Presenter;

import com.juansm.schoolmanager.Interface.TeacherPresenterInterface;
import com.juansm.schoolmanager.Model.DAOs.TeacherDAO;
import com.juansm.schoolmanager.Model.Entities.Teacher;

import java.util.List;

public class TeacherPresenter implements TeacherPresenterInterface {

    private static TeacherPresenter presenter;

    public static TeacherPresenter getInstance(){
        if (presenter==null){
            presenter = new TeacherPresenter();
        }
        return presenter;
    }

    private TeacherPresenter(){

    }

    public boolean insertNewTeacher(Teacher teacher){
        TeacherDAO dao = TeacherDAO.getInstance();
        if (dao.insertTeacher(teacher)){
            return true;
        }else{
            return false;
        }
    }

    public boolean removeTeacher(Long id){
        TeacherDAO dao = TeacherDAO.getInstance();
        if (dao.removeTeacher(id)){
            return true;
        }else{
            return false;
        }
    }

    public boolean removeTeacher(Teacher teacher){
        TeacherDAO dao = TeacherDAO.getInstance();
        if (dao.removeTeacher(teacher.getId())){
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyExitTeacher(Teacher teacher){
        TeacherDAO dao = TeacherDAO.getInstance();
        if (dao.modifyTeacher(teacher)){
            return true;
        }else{
            return false;
        }
    }

    public List<Teacher> readTeachers(){
        TeacherDAO dao = TeacherDAO.getInstance();

        return dao.getTeachers();
    }

    public List<Teacher> readTeachersReduced() {
        TeacherDAO dao = TeacherDAO.getInstance();

        return dao.getTeachersReduced();
    }
}
