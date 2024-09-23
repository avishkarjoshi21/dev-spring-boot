package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
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
			//createCourseAndReviews(appDAO);

			//retrieveCourseAndReviews(appDAO);

			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int id = 10;

		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		// print the courese
		System.out.println(course);

		// print the reviews
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create course
		Course course = new Course("Pacman - How to score One Million Points");

		// add some reviews
		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course ... job well done!"));
		course.addReview(new Review("What a dumb course ... you are an idiot!"));

		// save the course
		System.out.println("saving the course");

		System.out.println(course);
		System.out.println(course.getReviews());
		appDAO.saveCourse(course);

		System.out.println("Done!");

	}


}
