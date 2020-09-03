package com.douglasmoreira.coursemc.repositories;

import com.douglasmoreira.coursemc.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
}
