package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

//Provides methods for managing students, such as subscribing, finding, and showing student summaries.
//StudentService.java uses the Student.java class to represent individual students, and it also uses the Course.java class to enroll students in courses.

public class StudentService
{
    //a private field students which is a HashMap that stores students with their IDs as keys.
    private final Map<String, Student> students = new HashMap<>();

    //This method adds a student to the students map with their ID as the key.
    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    //his method checks if a student with the given ID exists in the students map and returns the student if found, otherwise returns null.
    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    // intended to check if a student with the given ID is subscribed.
    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        if (students.containsKey( studentId )) {
            return true;
        }
        // end of TODO
        return false;
    }

    //show a summary of students.
    public void showSummary()
    {
        //TODO implement
        for (Student student : students.values()) {
            System.out.println("Student: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Birth Date: " + student.getBirthDate());
            System.out.println("Courses:");
            for (Course course : student.getCourses()) {
                System.out.println(course);
            }
            System.out.println();
        }
        //end of TODO
    }

    //This method enrolls a student with the given ID in a course if the student exists in the students map.
    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}
