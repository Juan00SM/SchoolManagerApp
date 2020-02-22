package com.juansm.schoolmanager.Model.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends Person{

    private String communicationDay; //format of 'day-hour' or new attribute for hour
    private String communicationHour;
    private Integer isTutor;

    //super --> Long id, String name, String lastName, Long idGender, Date birthDate, String email, String phone, Long address
    public Teacher(Long id, String name, String lastName, Long idGender, String birthDate, String email, String phone, String address,String img,
                   String communicationDay, String communicationHour, int isTutor) {
        super(id, name, lastName, idGender, birthDate, email, phone, address,img);
        setCommunicationDay(communicationDay);
        setCommunicationHour(communicationHour);
        setIsTutor(isTutor);
    }

    public Teacher(String communicationDay, String communicationHour, int isTutor) {
        setCommunicationDay(communicationDay);
        setCommunicationHour(communicationHour);
        setIsTutor(isTutor);
    }

    public Teacher() {
    }

    public String getCommunicationDay() {
        return communicationDay;
    }

    public boolean setCommunicationDay(String communicationDay) {
        if (communicationDay!=null){
            Pattern pat = Pattern.compile("(lunes|martes|mi[é|e]rcoles|jueves|viernes)");
            Matcher mat = pat.matcher(communicationDay.toLowerCase());
            if (mat.matches()) {
                this.communicationDay = communicationDay;
                return true;
            }else {
                return false;
            }
        }
        return false;

    }

    public String getCommunicationHour() {
        return communicationHour;
    }

    public boolean setCommunicationHour(String communicationHour) {
        if (communicationHour!=null){
            Pattern pat = Pattern.compile("^(0[0-9]|1[0-9]|2[0123])(\\:)(0[0-9]|[12345][0-9])");
            Matcher mat = pat.matcher(communicationHour);
            if (mat.matches()) {
                this.communicationHour = communicationHour;
                return true;
            }else {
                return false;
            }
        }
        return false;

    }

    public Integer getIsTutor() {

        return isTutor;
    }

    public boolean setIsTutor(int isTutor) {
        if (isTutor == 1){
            this.isTutor = isTutor;
            return  true;
        }else if (isTutor == 0){
            this.isTutor = isTutor;
            return true;
        }else{
            return false;
        }
    }
}
