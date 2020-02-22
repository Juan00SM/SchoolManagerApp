package com.juansm.schoolmanager.Model.DAOs;

public class SubjectDAO {
    private static SubjectDAO dao;

    public static SubjectDAO getInstance(){
        if (dao==null){
            dao = new SubjectDAO();
        }
        return dao;
    }

    public SubjectDAO() {
    }
}
