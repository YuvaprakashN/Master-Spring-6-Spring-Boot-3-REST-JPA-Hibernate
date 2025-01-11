package com.eazybytes.eazyschool.eazyschool.repository;

import com.eazybytes.eazyschool.eazyschool.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    List<Contact> findByStatus(String status);
}
