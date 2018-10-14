package com.mattar.areen.databaseex;

import java.util.Arrays;

public class Contact {
    private long id;
    private String name;
    private String email;
    private String phone;
    private  byte[] contactImage;

    public Contact(long id, String name, String email, String phone, byte[] contactImage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.contactImage = contactImage;
    }

    public Contact() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public byte[] getContactImage() {
        return contactImage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContactImage(byte[] contactImage) {
        this.contactImage = contactImage;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", contactImage=" + Arrays.toString(contactImage) +
                '}';
    }
}

