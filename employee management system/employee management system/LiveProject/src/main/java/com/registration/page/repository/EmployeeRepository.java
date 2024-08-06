package com.registration.page.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registration.page.model.Details;

@Repository
public interface EmployeeRepository extends JpaRepository<Details, Long> {

    @Query("SELECT d FROM Details d WHERE d.role = 'employee'")
    List<Details> findEmployeesByRole();
}
