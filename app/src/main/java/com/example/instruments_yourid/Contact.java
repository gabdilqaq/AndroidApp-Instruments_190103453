package com.example.instruments_yourid;

public class Contact {
    private String surname;
    private String name;
    private String phone;
    private int imageResourceId;

    private Contact(String surname,String name,String phone, int imageResourceId){
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.imageResourceId = imageResourceId;
    }
    public static final Contact[] contacts = {
        new Contact("Malikov","Azamat","87012451478",R.drawable.one),
        new Contact("Medetov","Zhandos","87714875269",R.drawable.two),
        new Contact("Ryszhanov","Aman","87054861498", R.drawable.five),
        new Contact("Sapar","Oralbek","87081665567",R.drawable.four)
    };
    public String getSurname() { return surname;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public int getImageResourceId() { return imageResourceId;}
    public String toString() { return this.name;}

}

