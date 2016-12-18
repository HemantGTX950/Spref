package com.example.hemantbansal.spref;

/**
 * Created by Hemant Bansal on 10/21/2016.
 */

public class PersonDetails {
    private String name;
    private String surname;
    private Car[] cars;
    private int phone;
    private transient int age;

    public PersonDetails(  String name,String surname, int phone, int age,Car[] cars) {
        this.age = age;
        this.cars = cars;
        this.name = name;
        this.phone = phone;
        this.surname = surname;
    }

    @Override
    public String toString() {
        StringBuilder sr=new StringBuilder();

        sr.append("Name: "+name+" "+surname+"\n");
        sr.append("Phone: " + phone + "\n");
        sr.append("Age: " + age + "\n");
        int i = 0;
        for (Car item : cars){
            i++;
            sr.append("Car " + i + ": " + item + "\n");
        }

        return sr.toString();

    }
}
