package com.juansm.schoolmanager.Model.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    private Long id;
    private String typeEducation;
    private int courseNumber;

    public Course(Long id, String typeEducation, int courseNumber) {
        setId(id);
        setCourseNumber(courseNumber);
        setTypeEducation(typeEducation);
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public boolean setId(Long id) {
        if (id!=null){
            if (id>-1){
                this.id = id;
                return true;
            }
        }
        return false;
    }

    public String getTypeEducation() {
        return typeEducation;
    }

    public boolean setTypeEducation(String typeEducation) {
        Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
        Matcher mat = pat.matcher(typeEducation);
        if (mat.matches()) {
            this.typeEducation = typeEducation;
            return true;
        }else {
            return false;
        }
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public boolean setCourseNumber(int courseNumber) {
        if (courseNumber>0 && courseNumber<7){
            this.courseNumber = courseNumber;
            return true;
        }else{
            return false;
        }
    }
}
