package com.eazybytes.eazyschool.eazyschool.repository;

import com.eazybytes.eazyschool.eazyschool.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidaysRepository extends JpaRepository<Holiday,String> {
}
