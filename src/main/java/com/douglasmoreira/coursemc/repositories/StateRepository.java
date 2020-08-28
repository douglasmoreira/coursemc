package com.douglasmoreira.coursemc.repositories;

import com.douglasmoreira.coursemc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<Category, Integer> {
}
