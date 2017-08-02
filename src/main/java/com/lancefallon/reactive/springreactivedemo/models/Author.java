package com.lancefallon.reactive.springreactivedemo.models;

import java.util.Date;

public class Author {

    private String name;
    private String country;
    private Date dob;

    public Author() {
    }

    public Author(String name, String country, Date dob) {
        this.name = name;
        this.country = country;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                '}';
    }
}
