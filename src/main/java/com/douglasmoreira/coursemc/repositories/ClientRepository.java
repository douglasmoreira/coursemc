package com.douglasmoreira.coursemc.repositories;

import com.douglasmoreira.coursemc.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
