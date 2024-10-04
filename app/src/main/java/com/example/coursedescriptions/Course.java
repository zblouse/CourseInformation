package com.example.coursedescriptions;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO for information on each Course
 */
public class Course implements Serializable {

    private final String courseCode;
    private final String courseName;
    private final String courseDescription;
    private final int credits;

    public Course(String courseCode, String courseName, String courseDescription, int credits){
        this.courseCode=Objects.requireNonNull(courseCode, "courseCode may not be null");
        this.courseName=Objects.requireNonNull(courseName, "courseName may not be null");
        this.courseDescription=Objects.requireNonNull(courseDescription, "courseDescription may not be null");
        this.credits=credits;
    }

    public String getCourseCode(){
        return this.courseCode;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public String getCourseDescription(){
        return this.courseDescription;
    }

    public int getCredits(){
        return this.credits;
    }
}
