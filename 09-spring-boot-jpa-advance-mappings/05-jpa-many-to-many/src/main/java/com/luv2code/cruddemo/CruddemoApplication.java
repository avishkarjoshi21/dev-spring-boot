package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createCourseAndStudents(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);

			//addMoreCoursesForStudents(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int studentId = 1;

		System.out.println("Deleting student id:" + studentId);

		appDAO.deleteStudentById(studentId);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int courseId = 10;

		System.out.println("Deleting course id:" + courseId);

		appDAO.deleteCourseById(courseId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {
		int studentId = 2;

		Student student = appDAO.findStudentAndCourseByStudentId(studentId);

		// create more courses
		Course course1 = new Course("Rubik's Cube - How to Speed Cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		// add courses to the student
		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Updating Student" + student);
		System.out.println("Associated Courses:" + student.getCourses());

		appDAO.updateStudent(student);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int studentId = 1;

		Student student = appDAO.findStudentAndCourseByStudentId(studentId);

		System.out.println("Loaded Student:" + student);
		System.out.println("Courses:" + student.getCourses());

		System.out.println("Done!");

	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int courseId = 10;

		Course course = appDAO.findCourseAndStudentByCourseId(courseId);

		System.out.println("Loaded course:" + course);
		System.out.println("Students:" + course.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course course = new Course("Pacman - How to Score One Million Points");

		// create the students
		Student john = new Student("John", "Doe", "john@luv2code.com");
		Student mary = new Student("Mary", "Public", "mary@luv2code.com");

		// add student to course
		course.addStudent(john);
		course.addStudent(mary);

		// save the course and associated students
		System.out.println("Saving the course:" + course);
		System.out.println("Associated students:" + john);

		appDAO.saveCourse(course);

		System.out.println("Done!");

	}
}
