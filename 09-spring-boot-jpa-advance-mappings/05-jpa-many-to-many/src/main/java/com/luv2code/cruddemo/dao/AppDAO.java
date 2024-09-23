package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    Course findCourseById(int id);

    void updateCourse(Course course);

    void deleteCourseById(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentByCourseId(int id);

    Student findStudentAndCourseByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudentById(int id);
}
