package com.mapping;

import com.mapping.entity.Laptop;
import com.mapping.entity.Student;
import com.mapping.entity.repositoty.LaptopRepository;
import com.mapping.entity.repositoty.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingApplication implements CommandLineRunner {
  	 Logger logger= LoggerFactory.getLogger(MappingApplication.class);
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LaptopRepository laptopRepository;

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student=new Student();
		student.setStudentId(2);
		student.setStudentName("Virat");
		student.setAbout("He is a good student");


		Laptop laptop=new Laptop();
		laptop.setLaptopId(2);
		laptop.setBrand("Lenovo");
		laptop.setModelNumber("269996666");

		// important
		laptop.setStudent(student);
		student.setLaptop(laptop);
		Student save=studentRepository.save(student);
	/*	Laptop saveLaptop=laptopRepository.save(laptop);*/
		logger.info("saved student : {}", save.getStudentName());
		Laptop get=student.getLaptop();
		logger.info("saved laptop  {},{}", laptop.getLaptopId(), laptop.getBrand());



	}
}
