package com.company.form;

public class UserEntityForm {
    Integer id;
    String name;
    String surname;
    Integer nationalityID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntityForm(Integer id, String name, String surname, Integer nationalityID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationalityID = nationalityID;
    }

    public UserEntityForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(Integer nationalityID) {
        this.nationalityID = nationalityID;
    }
}
