package com.generation.model;

import java.util.Date;

// A base class for Student with attributes like ID, name, email, and birthdate.
//The Person class serves as a base class for other classes like Student and Instructor, providing common attributes that they can inherit.

abstract public class Person
{
    private final String id;

    private final String name;

    private final String email;

    private final Date birthDate;

    protected Person( String id, String name, String email, Date birthDate )
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    @Override
    public String toString()
    {
        return id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", birthDate=" + birthDate;
    }
}
