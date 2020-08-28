package com.douglasmoreira.coursemc.repositories;

import com.douglasmoreira.coursemc.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
