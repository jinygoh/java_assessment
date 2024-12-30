package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//This class is a test class for the CourseService.
public class CourseServiceTest {

    //The service being tested.
    private CourseService courseService;

    @BeforeEach
    public void setup() {
        // Create a new instance of the CourseService for each test
        courseService = new CourseService();
    }

    // Tests the registration of a new course.
    @Test
    public void testRegisterCourse() {
        // Create a new course
        Course course = new Course("TEST-1", "Test Course", 9, new Module("TEST", "Test Module", "Test module description"));

        // Register the course using the CourseService
        courseService.registerCourse(course);

        // Verify that the course is successfully registered by retrieving it from the CourseService
        // If the course is registered, the getCourse method should not return null
        assertNotNull(courseService.getCourse("TEST-1"));
    }

    // Test case for the getCourse() method
    @Test
    public void testGetCourse() {
        // Create a new course
        Course course = new Course("TEST-1", "Test Course", 9, new Module("TEST", "Test Module", "Test module description"));

        // Register the course
        courseService.registerCourse(course);

        // Check if the course is retrieved correctly
        assertEquals(course, courseService.getCourse("TEST-1"));
    }
    
}