package com.anuj.cruddemo;

import com.anuj.cruddemo.dao.StudentDAO;
import com.anuj.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		//create student object
		Student tmpStudent = new Student("anuj","thapa","anuj.thapa@mail.com");
		Student tmpStudent1 = new Student("anuj1","thapa","anuj.thapa1@mail.com");
		Student tmpStudent2 = new Student("anuj2","thapa","anuj.thapa2@mail.com");

		//save student object
		System.out.println("Saving student object.....");
		studentDAO.save(tmpStudent);
		studentDAO.save(tmpStudent1);
		studentDAO.save(tmpStudent2);

		//display id of saved student
		System.out.println("Saved Student, Generated ID:" + tmpStudent.getId());
	}

}
