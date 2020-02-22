package com.juansm.schoolmanager.Model.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {

    private Long id;
    private Long idSubject;
    private String matter;
    private String description;
    private String deliveryDate;

    public Homework(Long id, Long idSubject, String matter, String description, String deliveryDate) {
        setId(id);
        setIdSubject(idSubject);
        setMatter(matter);
        setDeliveryDate(deliveryDate);
        setDescription(description);
    }

    public Homework() {
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

    public Long getIdSubject() {
        return idSubject;
    }

    public boolean setIdSubject(Long idSubject) {
        if (idSubject!=null){
            if (idSubject>-1){
                this.idSubject = idSubject;
                return true;
            }
        }
        return false;
    }

    public String getMatter() {
        return matter;
    }

    public boolean setMatter(String matter) {
        if (matter!=null && !matter.equals("")){
            this.matter = matter;
            return true;
        }else{
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    //02-02-2000  or   02/02/2000
    public boolean setDeliveryDate(String deliveryDate) {

        Pattern pat = Pattern.compile("^((([0][1-9]|[12][0-9]|3[01])(\\/|\\-)([0][13-9]|[1][0-2]))|(([0][1-9]|[12][0-9])(\\/|\\-)02))(\\/|\\-)(\\d{4})");
        Matcher mat = pat.matcher(deliveryDate);
        if (mat.matches()) {
            this.deliveryDate = deliveryDate;
            return true;
        }else {
            return false;
        }
    }
}
