package com.example.hemantbansal.spref;

/**
 * Created by Hemant Bansal on 10/17/2016.
 */

public class Student {

    private String name,classname;

    public Student(String name, String classname) {
        this.classname = classname;

        this.name = name;
    }

    public String getClassname() {
        return classname;
    }


    public String getName() {
        return name;
    }
}
