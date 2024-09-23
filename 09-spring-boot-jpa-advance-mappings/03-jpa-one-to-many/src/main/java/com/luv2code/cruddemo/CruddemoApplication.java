package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);

			//crateInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			//updateCourse(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting the course id:"+ id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		// find the course
		System.out.println("Finding course with id " + id);
		Course course = appDAO.findCourseById(id);
		System.out.println("Found course with id " + course);

		// update the course
		course.setTitle("Enjoy the simple things");

		appDAO.updateCourse(course);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		// find the instructor
		Instructor instructor = appDAO.findInstructorById(id);

		// update the instructor
		instructor.setLastName("TESTER");
		instructor.setEmail("susan.tester@luv2code.com");

		appDAO.updateInstructor(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor by id:"+id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("instructor:" + instructor);
		System.out.println("Associated courses:"+ instructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor by id:"+id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor:"+instructor);
		// find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// associate the objects
		instructor.setCourses(courses);

		System.out.println("Associated courses:"+ instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor by id:"+id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor:"+instructor);
		System.out.println("Associated courses:"+ instructor.getCourses());
		System.out.println("Done!");
	}

	private void crateInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Video Games");

		// associate the object
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.addCourse(course1);
		instructor.addCourse(course2);

		// save the instructor
		//
		// NOTE: this will also save courses object because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+ instructor);
		System.out.println("The Courses: "+ instructor.getCourses());
		appDAO.save(instructor);


		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id =3;

		System.out.println("Deleting instructor detail id:" +id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;

		System.out.println("Finding instructor details id:" + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor Detail: "+instructorDetail);
		System.out.println("Associated Instructor:"+ instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id =1;

		System.out.println("Deleting instructor id:" + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;

		System.out.println("Finding instructor id:" + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: "+instructor);
		System.out.println("Associated Instructor Detail:"+ instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

		// associate the object
		instructor.setInstructorDetail(instructorDetail);

		/*Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "guitar");

		instructor.setInstructorDetail(instructorDetail);*/

		// save the instructor
		//
		// NOTE: this will also save Instructor detail object
		System.out.println("Saving instructor: "+instructorDetail);
		appDAO.save(instructor);

		System.out.println("Done");
	}

}
