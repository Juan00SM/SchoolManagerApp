package com.juansm.schoolmanager.Interface;

import com.juansm.schoolmanager.Model.Entities.Gender;
import com.juansm.schoolmanager.Model.Entities.Teacher;

import java.util.List;

public interface GenderPresenterInterface {

    Long insertNewGender(Gender gender);
    boolean removeGender(Long id);
    boolean removeGender(Gender gender);
    boolean modifyExitGender(Gender gender);
    List<Gender> readGenders();
}
