package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numOfStudentsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numOfStudentsDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete the student
		long id = 3;

		System.out.println("Deleting student with id " + id);

		studentDAO.delete(id);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve the student by id: Primary Key
		long id=1;
		System.out.println("Getting student with id: " + id);
		Student student = studentDAO.findById(id);

		// display the retrieve student
		System.out.println(student);

		// change first name of retrieve student
		System.out.println("Updating student....");
		student.setFirstName("John");

		// update the student
		studentDAO.update(student);

		// display updated student
		System.out.println("Updated student :"+ student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findByLastName("Doe");

		// display the list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object

		System.out.println("Creating new student object...");
		Student student = new Student("Daffy","Duck", "daffy@luv2code.com");

		// save the student
		studentDAO.save(student);

		// display id of the save student
		long id = student.getId();
		System.out.println("saved student. Generated id: " + id);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id " + id);
		Student myStudent = studentDAO.findById(id);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students

		System.out.println("Creating 3 student object...");
		Student student1 = new Student("John","Doe", "john@luv2code.com");
		Student student2 = new Student("Mary","Public", "mary@luv2code.com");
		Student student3 = new Student("Bonita","Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the Students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);



	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating the student object...");
		Student student = new Student("Paul","Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("saving the student...");
		studentDAO.save(student);

		// display id of the save student
		System.out.println("saved student. Generated id: " + student.getId());
	}

}
