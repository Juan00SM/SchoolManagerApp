package com.juansm.schoolmanager.Model.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subject {
    private Long id;
    private String name;
    private String department;
    private String description;
    private Long idTeacher;

    public Subject(Long id, String name, String department, String description, Long idTeacher) {
        setId(id);
        setName(name);
        setDepartment(department);
        setDescription(description);
        setIdTeacher(idTeacher);
    }

    public Subject() {
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

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
        Matcher mat = pat.matcher(name);
        if (mat.matches()) {
            this.name = name;
            return true;
        }else {
            return false;
        }
    }

    public String getDepartment() {
        return department;
    }

    public boolean setDepartment(String department) {
        Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
        Matcher mat = pat.matcher(department);
        if (mat.matches()) {
            this.department = department;
            return true;
        }else {
            return false;
        }
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (description!=null && !description.equals("")){
            this.description = description;
            return true;
        }else{
            return false;
        }
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public boolean setIdTeacher(Long idTeacher) {
        if (idTeacher!=null){
            if (idTeacher>-1){
                this.idTeacher = idTeacher;
                return true;
            }
        }
        return false;
    }
}
