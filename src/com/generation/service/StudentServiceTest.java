package com.generation.service;

import com.generation.model.*;
import com.generation.model.Course;
import com.generation.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//This class contains test cases for the StudentService class.
//It tests the functionality of subscribing students, finding students,
//checking if a student is subscribed, and showing a summary of subscribed students.
public class StudentServiceTest {

    // The StudentService instance to be tested
    private StudentService studentService;

    //Sets up a new StudentService instance before each test.
    @BeforeEach
    public void setup() {
        studentService = new StudentService();
    }

    //Tests subscribing a new student.
    @Test
    public void testSubscribeStudent_NewStudent() throws ParseException {
        // Given: a new student with a unique ID, name, email, and birthdate
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = dateFormat.parse("01/01/1990");
        Student student = new Student("1", "John Doe", "john.doe@example.com", birthDate);

        // When: the student is subscribed
        studentService.subscribeStudent(student);

        // Then: the student can be found by their ID
        assertNotNull(studentService.findStudent("1"));
    }

    //Tests subscribing an existing student.
    @Test
    public void testSubscribeStudent_ExistingStudent() throws ParseException {
        // Given: an existing student with a unique ID, name, email, and birth date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = dateFormat.parse("01/01/1990");
        Student student = new Student("1", "John Doe", "john.doe@example.com", birthDate);
        studentService.subscribeStudent(student);

        // When: the student is subscribed again
        studentService.subscribeStudent(student);

        // Then the student's information remains the same
        assertEquals(student, studentService.findStudent("1"));
    }

    //Tests finding an existing student.
    @Test
    public void testFindStudent_ExistingStudent() throws ParseException { //throws ParseException if the date format is incorrect
        // Given: an existing student with a unique ID, name, email, and birth date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = dateFormat.parse("01/01/1990");
        Student student = new Student("1", "John Doe", "john.doe@example.com", birthDate);
        studentService.subscribeStudent(student);

        // When: the student is found by their ID
        Student foundStudent = studentService.findStudent("1");

        // Then: the found student matches the original student
        assertEquals(student, foundStudent);
    }

    //Tests finding a non-existent student.
    @Test
    public void testFindStudent_NonExistentStudent() {
        // Given: no student with the given ID

        // When: the student is found by their ID
        Student foundStudent = studentService.findStudent("1");

        // Then: the found student is null
        assertNull(foundStudent);
    }

    // Tests if a subscribed student is correctly identified as subscribed.
    @Test
    public void testIsSubscribed_SubscribedStudent() throws ParseException {
        // Given: a new student with a unique ID, name, email, and birthdate
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = dateFormat.parse("01/01/1990");
        Student student = new Student("1", "John Doe", "john.doe@example.com", birthDate);
        studentService.subscribeStudent(student);

        // When: check if the student is subscribed
        boolean isSubscribed = studentService.isSubscribed("1");

        // Then: the student should be subscribed
        assertTrue(isSubscribed);
    }

    // Tests if a non-existent student is correctly identified as not subscribed.
    @Test
    public void testIsSubscribed_NonExistentStudent() {
        // Given: no student with the given ID exists in the system

        // When: the subscription status of the non-existent student is checked
        boolean isSubscribed = studentService.isSubscribed("1");

        // Then: the non-existent student should not be subscribed
        assertFalse(isSubscribed);
    }

    //This test method checks if the showSummary method of the StudentService classcorrectly shows a summary of subscribed students.It does not check the content of the summary, only that the method does not throw any exceptions.
    @Test
    public void testShowSummary_SubscribedStudents() throws ParseException {
        // Given: a new student with a unique ID, name, email, and birth date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = dateFormat.parse("01/01/1990");
        Student student = new Student("1", "John Doe", "john.doe@example.com", birthDate);

        // When: the student is subscribed and the summary is shown
        studentService.subscribeStudent(student);
        studentService.showSummary();

        // Then: No assertion needed, just verify that the method doesn't throw any exceptions
        // This test is more about ensuring that the method can be called without throwing any errors
    }

    //Test case for the showSummary method when there are no subscribed students.This test verifies that the method does not throw any exceptions when there are no subscribed students.
    @Test
    public void testShowSummary_NoSubscribedStudents() {
        // Given: No students are subscribed

        // When: The showSummary method is called
        studentService.showSummary();

        // Then: The method should not throw any exceptions
        // No explicit assertion is needed, as the test will pass if no exceptions are thrown
    }

    //Test case to verify that a subscribed student can enroll in a course.
    @Test
    public void testEnrollToCourse_SubscribedStudent() throws ParseException {
        // Given a new student with a unique ID, name, email, and birthdate
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = dateFormat.parse("01/01/1990");
        Student student = new Student("1", "John Doe", "john.doe@example.com", birthDate);

        // Create a new course
        Course course = new Course("Math 101", "Description", 3, new Module("Math", "Mathematics Module", "MATH-101"));

        // Subscribe the student to the student service
        studentService.subscribeStudent(student);

        // When: the student enrolls in the course
        studentService.enrollToCourse("1", course);

        // Then: the student should be enrolled in the course
        assertTrue(student.getCourses().contains(course));
    }

}