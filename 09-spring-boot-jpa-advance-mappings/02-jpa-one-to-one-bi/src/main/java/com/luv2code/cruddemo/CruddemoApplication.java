package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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

			deleteInstructorDetail(appDAO);
		};
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

		System.out.println("Deleting instructor id:"+id);

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
