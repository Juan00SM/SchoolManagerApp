package com.juansm.schoolmanager.Model.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person implements Parcelable {
    private Long idCourse;
    private String nameFather;
    private String fatherPhone;
    private String nameMother;
    private String motherPhone;

    //super --> Long id, String name, String lastName, Long idGender, Date birthDate, String email, String phone, Long address
    public Student(Long id, String name, String lastName, Long idGender, String birthDate, String email, String phone, String address, String img) {
        super(id, name, lastName, idGender, birthDate, email, phone, address, img);
    }

    public Student(Long id, String name, String lastName, Long idGender, String birthDate, String email, String phone, String address,String img,
                   Long idCourse, String nameFather, String fatherPhone, String nameMother, String motherPhone) {
        super(id, name, lastName, idGender, birthDate, email, phone, address,img);
        setIdCourse(idCourse);
        setNameFather(nameFather);
        setFatherPhone(fatherPhone);
        setNameMother(nameMother);
        setMotherPhone(motherPhone);
    }

    public Student(Long idCourse, String nameFather, String fatherPhone, String nameMother, String motherPhone) {
        setIdCourse(idCourse);
        setNameFather(nameFather);
        setFatherPhone(fatherPhone);
        setNameMother(nameMother);
        setMotherPhone(motherPhone);
    }

    public Student() {
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public boolean setIdCourse(Long idCourse) {
        if (idCourse!=null){
            if (idCourse>-1){
                this.idCourse = idCourse;
                return true;
            }
        }
        return false;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public boolean setFatherPhone(String fatherPhone) {
        if (fatherPhone!=null){
            Pattern pat = Pattern.compile("^[9|6|7][0-9]{8}$");
            Matcher mat = pat.matcher(fatherPhone);
            if (mat.matches()) {
                this.fatherPhone = fatherPhone;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public boolean setMotherPhone(String motherPhone) {
        if (motherPhone!=null){
            Pattern pat = Pattern.compile("^[9|6|7][0-9]{8}$");
            Matcher mat = pat.matcher(motherPhone);
            if (mat.matches()) {
                this.motherPhone = motherPhone;
                return true;
            }else {
                return false;
            }
        }
        return false;

    }

    public String getNameFather() {
        return nameFather;
    }

    public boolean setNameFather(String nameFather) {
        if (nameFather!=null){
            Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
            Matcher mat = pat.matcher(nameFather);
            if (mat.matches()) {
                this.nameFather = nameFather;
                return true;
            }else {
                return false;
            }
        }
        return false;

    }

    public String getNameMother() {
        return nameMother;
    }

    public boolean setNameMother(String nameMother) {
        if (nameMother!=null){
            Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
            Matcher mat = pat.matcher(nameMother);
            if (mat.matches()) {
                this.nameMother = nameMother;
                return true;
            }else {
                return false;
            }
        }
        return false;

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idCourse);
        dest.writeString(this.nameFather);
        dest.writeString(this.fatherPhone);
        dest.writeString(this.nameMother);
        dest.writeString(this.motherPhone);
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.lastName);
        dest.writeValue(this.idGender);
        dest.writeString(this.birthDate);
        dest.writeString(this.email);
        dest.writeString(this.phone);
        dest.writeString(this.address);
        dest.writeString(this.img);
    }

    protected Student(Parcel in) {
        this.idCourse = (Long) in.readValue(Long.class.getClassLoader());
        this.nameFather = in.readString();
        this.fatherPhone = in.readString();
        this.nameMother = in.readString();
        this.motherPhone = in.readString();
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.lastName = in.readString();
        this.idGender = (Long) in.readValue(Long.class.getClassLoader());
        this.birthDate = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.address = in.readString();
        this.img = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
