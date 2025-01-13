package com.eazybytes.eazyschool.eazyschool.repository;

import com.eazybytes.eazyschool.eazyschool.model.EazyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass,Integer> {
}
