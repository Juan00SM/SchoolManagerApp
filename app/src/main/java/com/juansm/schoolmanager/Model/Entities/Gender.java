package com.juansm.schoolmanager.Model.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gender {

    private Long id;
    private String name;
    private String description;

    public Gender(Long id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public Gender() {
    }

    public Long getId() {
        return id;
    }

    public boolean setId(Long id) {
        if (id!=null){
            if (id>-2){
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
        if (name!=null){
            Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
            Matcher mat = pat.matcher(name);
            if (mat.matches()) {
                this.name = name;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (description!=null){
            Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
            Matcher mat = pat.matcher(description);
            if (mat.matches()) {
                this.description = description;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
