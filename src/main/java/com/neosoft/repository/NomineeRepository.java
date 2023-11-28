package com.neosoft.repository;

import com.neosoft.model.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee,Integer> {
}
