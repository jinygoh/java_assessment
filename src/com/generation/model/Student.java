package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Represents a student with attributes like ID, name, email, birth date, and a list of courses.
//Student.java extends the Person.java class, which provides common attributes like ID, name, email, and birth date.
//class implements the Evaluation interface, which suggests that it provides methods for evaluating student performance.
public class Student
    extends Person
    implements Evaluation
{
    //The student's average grade.
    private double average;
    //A list of courses the student is currently enrolled in.
    private final List<Course> courses = new ArrayList<>();
    //A map of approved courses for the student, keyed by course code.
    private final Map<String, Course> approvedCourses = new HashMap<>();


    // Constructor for a student object.
    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    // Enrolls the student in the given course by adding the course to the list of enrolled courses.
    public void enrollToCourse( Course course )
    {
        //TODO implement this method
        courses.add( course );
        // end of TODO
    }

    // added this myself
    public List<Course> getCourses() {
        return courses;
    }
    //

    //Registers an approved course for the student.
    public void registerApprovedCourse( Course course )
    {
        //Add the course to the map of approved courses, keyed by course code
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
        if (approvedCourses.containsKey(courseCode)) {
            return true;
        }
        // end of TODO
        return false;
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course )
    {
        //TODO implement this method

        // end of TODO
        return null;
    }

    //Checks if the student is attending a course with the given course code.
    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        // end of TODO
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

     // Returns a list of courses that the student has been approved for.
     //This method retrieves the list of approved courses from the approvedCourses map.
     // return A list of approved Course objects.
    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        // Return the list of approved courses for the student
        // created a new ArrayList to avoid modifying the original map values
        if (!approvedCourses.isEmpty()) {
            return new ArrayList<>(approvedCourses.values());
        }
        // end of TODO
        return null;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

    // i added this cuz there's no setGrade
    public void setGrade(double grade) {
    }
    //
}
