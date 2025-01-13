package com.eazybytes.eazyschool.eazyschool.repository;

import com.eazybytes.eazyschool.eazyschool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
