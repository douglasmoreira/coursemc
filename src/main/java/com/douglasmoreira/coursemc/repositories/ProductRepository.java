package com.douglasmoreira.coursemc.repositories;

import com.douglasmoreira.coursemc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
