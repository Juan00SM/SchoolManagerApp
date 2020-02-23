package com.juansm.schoolmanager.Model.Entities;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    protected Long id;
    protected String name;
    protected String lastName;
    protected Long idGender;
    protected String birthDate;
    protected String email;
    protected String phone; // example format: 698517827
    protected String address;
    protected String img;

    // auto generated id???
    public Person(Long id, String name, String lastName, Long idGender, String birthDate, String email, String phone, String address, String img) {
        setId(id);
        setName(name);
        setLastName(lastName);
        setIdGender(idGender);
        setBirthDate(birthDate);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
        setImg(img);
    }

    public Person() {
    }

    public String getImg() {
        return img;
    }

    public boolean setImg(String img) {
        if (img!=null&&!img.equals("")){
            this.img = img;
            return true;
        }
        return false;
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

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if (lastName!=null){
            Pattern pat = Pattern.compile("^([A-Za-zÁÉÍÓÚñáéíóúÑ\\']+[\\s]?)+");
            Matcher mat = pat.matcher(lastName);
            if (mat.matches()) {
                this.lastName = lastName;
                return true;
            }else {
                return false;
            }
        }
        return false;

    }

    public String getBirthDate() {
        return birthDate;
    }

    public boolean setBirthDate(String birthDate) {
        if (birthDate!=null){
            Pattern pat = Pattern.compile("^((([0][1-9]|[12][0-9]|3[01])(\\/)([0][13-9]|[1][0-2]))|(([0][1-9]|[12][0-9])(\\/)02))(\\/)(\\d{4})$");
            Matcher mat = pat.matcher(birthDate);
            if (mat.matches()) {
                this.birthDate = birthDate;
                return true;
            }else {
                return false;
            }
        }
        return false;


    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email!=null) {
            Pattern pat = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
            Matcher mat = pat.matcher(email);
            if (mat.matches()) {
                this.email = email;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        if (phone!=null){
            Pattern pat = Pattern.compile("^[9|6|7][0-9]{8}$");
            Matcher mat = pat.matcher(phone);
            if (mat.matches()) {
                this.phone = phone;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public Long getIdGender() {
        return idGender;
    }

    public boolean setIdGender(Long idGender) {

        if (idGender!=null){
            if (idGender>-1){
                this.idGender = idGender;
                return true;
            }
        }
        return false;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (address!=null){
            Pattern pat = Pattern.compile("^[A-Za-z(),.\\º\\d\\-\\/\\s]+$");
            Matcher mat = pat.matcher(address);
            if (mat.matches()) {
                this.address = address;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean isValid() {
        if (this.name!=null && this.phone!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) &&
                getName().equals(person.getName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getIdGender(), person.getIdGender()) &&
                Objects.equals(getBirthDate(), person.getBirthDate()) &&
                Objects.equals(getEmail(), person.getEmail()) &&
                getPhone().equals(person.getPhone()) &&
                Objects.equals(getAddress(), person.getAddress()) &&
                Objects.equals(getImg(), person.getImg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getIdGender(), getBirthDate(), getEmail(), getPhone(), getAddress(), getImg());
    }
}
