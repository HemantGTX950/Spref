package com.example.hemantbansal.spref;

/**
 * Created by Hemant Bansal on 10/4/2016.
 */

public class Person {

    private String username;
    private String password;

    public Person(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
