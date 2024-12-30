package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Instructor.java is not fully implemented, but it might be related to the Course.java class, possibly for representing instructors who teach courses.
// this class extends the Person.java class, which means it inherits all the attributes and methods of the Person class.

public class Instructor extends Person {

    //a private field experienceMonths to store the instructor's experience in months.
    private int experienceMonths;

    //a private field teachingCourses which is a list of Course objects, but it's not initialized.
    private final List<Course> teachingCourses = new ArrayList<>();

    //a protected constructor Instructor that takes id, name, email, and birthDate as parameters, and calls the Person class constructor with these parameters.
    protected Instructor( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    //getter method
    public int getExperienceMonths()
    {
        return experienceMonths;
    }

    //setter method - assigns new value to the experienceMonths field
    public void setExperienceMonths( int experienceMonths ) {
        this.experienceMonths = experienceMonths;
    }
}
