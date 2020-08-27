package com.douglasmoreira.coursemc;

import com.douglasmoreira.coursemc.domain.Category;
import com.douglasmoreira.coursemc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;

@SpringBootApplication
public class CourseMCApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseMCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");

		categoryRepository.saveAll(asList(cat1,cat2));
	}
}
