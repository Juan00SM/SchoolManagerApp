package com.juansm.schoolmanager.Presenter;

import com.juansm.schoolmanager.Interface.StudentPresenterInterface;
import com.juansm.schoolmanager.Model.DAOs.StudentDAO;
import com.juansm.schoolmanager.Model.Entities.Student;

import java.util.List;

public class StudentPresenter implements StudentPresenterInterface {

    private static StudentPresenter presenter;

    public static StudentPresenter getInstance(){
        if (presenter==null){
            presenter = new StudentPresenter();
        }
        return presenter;
    }

    private StudentPresenter(){

    }

    public Long insertNewStudent(Student student){
        StudentDAO dao = StudentDAO.getInstance();
        return dao.insertStudent(student);
    }

    public boolean removeStudent(Long id){
        StudentDAO dao = StudentDAO.getInstance();
        if (dao.removeStudent(id)){
            return true;
        }else{
            return false;
        }
    }

    public boolean removeStudent(Student student){
        StudentDAO dao = StudentDAO.getInstance();
        if (dao.removeStudent(student.getId())){
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyExitStudent(Student student){
        if (student!=null){
            StudentDAO dao = StudentDAO.getInstance();

            return dao.modifyStudent(student);
        }else{
            return false;
        }

    }

    public List<Student> readStudents(){
        StudentDAO dao = StudentDAO.getInstance();

        return dao.getStudents();
    }

    public List<Student> readStudentsReduced(){
        StudentDAO dao = StudentDAO.getInstance();

        return dao.getStudentsReduced();
    }

    public Student readStudentById(Long id){
        if (id!=null){
            StudentDAO dao = StudentDAO.getInstance();

            return dao.getStudentById(id);
        }else{
            return null;
        }

    }

    public List<Student> readStudentsByCriteriaReduced(String nameOrPhone, String date, Long idGender) {
        StudentDAO dao = StudentDAO.getInstance();

        return dao.getStudentsByCriteriaReduced(nameOrPhone, date, idGender);
    }
}
