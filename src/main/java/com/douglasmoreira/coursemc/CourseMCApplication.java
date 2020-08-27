package com.douglasmoreira.coursemc;

import com.douglasmoreira.coursemc.domain.Category;
import com.douglasmoreira.coursemc.domain.Product;
import com.douglasmoreira.coursemc.repositories.CategoryRepository;
import com.douglasmoreira.coursemc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;

@SpringBootApplication
public class CourseMCApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseMCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");

		Product p1 = new Product(null, "computing", 2000.0);
		Product p2 = new Product(null, "printer", 800.0);
		Product p3 = new Product(null, "mouse", 80.00);

		cat1.getProducts().addAll(asList(p1, p2, p3));
		cat2.getProducts().addAll(asList(p2));

		p1.getCategories().addAll(asList(cat1));
		p2.getCategories().addAll(asList(cat1, cat2));
		p3.getCategories().addAll(asList(cat1));

		categoryRepository.saveAll(asList(cat1,cat2));

		productRepository.saveAll(asList(p1, p2, p3));
	}
}
