package com.registration.page.service;

import com.registration.page.model.Details;
import com.registration.page.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Details> getEmployees() {
        return employeeRepository.findEmployeesByRole();
    }
}
