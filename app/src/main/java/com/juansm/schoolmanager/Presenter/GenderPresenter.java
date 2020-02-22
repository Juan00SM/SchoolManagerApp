package com.juansm.schoolmanager.Presenter;

import com.juansm.schoolmanager.Interface.GenderPresenterInterface;
import com.juansm.schoolmanager.Interface.TeacherPresenterInterface;
import com.juansm.schoolmanager.Model.DAOs.GenderDAO;
import com.juansm.schoolmanager.Model.DAOs.TeacherDAO;
import com.juansm.schoolmanager.Model.Entities.Gender;
import com.juansm.schoolmanager.Model.Entities.Teacher;

import java.util.List;

public class GenderPresenter implements GenderPresenterInterface {

    private static GenderPresenter presenter;

    public static GenderPresenter getInstance(){
        if (presenter==null){
            presenter = new GenderPresenter();
        }
        return presenter;
    }

    private GenderPresenter(){

    }

    public Long insertNewGender(Gender gender){
        GenderDAO dao = GenderDAO.getInstance();
        return dao.insertGender(gender);
    }

    public boolean removeGender(Long id){
        GenderDAO dao = GenderDAO.getInstance();
        if (dao.removeGender(id)){
            return true;
        }else{
            return false;
        }
    }

    public boolean removeGender(Gender gender){
        GenderDAO dao = GenderDAO.getInstance();
        if (dao.removeGender(gender.getId())){
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyExitGender(Gender gender){
        GenderDAO dao = GenderDAO.getInstance();
        if (dao.modifyGender(gender)){
            return true;
        }else{
            return false;
        }
    }

    public List<Gender> readGenders(){
        GenderDAO dao = GenderDAO.getInstance();

        return dao.getGenders();
    }

}
