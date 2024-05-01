package com.anuj.cruddemo;

import com.anuj.cruddemo.dao.StudentDAO;
import com.anuj.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
			//createDisplayStudent(studentDAO);
			//queryStudent(studentDAO);
			//queryByLastname(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteStudentAll(studentDAO);
		};
	}

	private void deleteStudentAll(StudentDAO studentDAO) {
		int deletedCount = studentDAO.deleteAll();
		System.out.println("Deleted record count:" + deletedCount);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentID = 1;
		studentDAO.delete(studentID);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentID = 2;
		Student stdinfo = studentDAO.findById(studentID);
		stdinfo.setFirstName("sanuj");
		studentDAO.update(stdinfo);
		System.out.println(stdinfo);
	}

	private void queryByLastname(StudentDAO studentDAO) {
		List<Student> studInfo = studentDAO.findByLastname("thapa");
		for(Student stud: studInfo){
			System.out.println(stud);
		}
	}

	private void queryStudent(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for(Student std: studentList){
			System.out.println(std);
		}
	}


	private void createDisplayStudent(StudentDAO studentDAO) {
		Student std = new Student("Akanksha", "Thapa", "akanksha.thapa@gmail.com");
		studentDAO.save(std);
		//Integer id = std.getId();
		Student stdinfo = studentDAO.findById(std.getId());
		System.out.println("New Student record:"+ stdinfo);


	}

	private void createStudent(StudentDAO studentDAO) {

		//create student object
		Student tmpStudent = new Student("anuj","thapa","anuj.thapa@mail.com");
		Student tmpStudent1 = new Student("sanuj","thapa","sanuj.thapa1@mail.com");
		Student tmpStudent2 = new Student("akanksha","akanksha","akanksha.thapa2@mail.com");

		//save student object
		System.out.println("Saving student object.....");
		studentDAO.save(tmpStudent);
		studentDAO.save(tmpStudent1);
		studentDAO.save(tmpStudent2);

		//display id of saved student
		System.out.println("Saved Student, Generated ID:" + tmpStudent.getId());
	}

}
