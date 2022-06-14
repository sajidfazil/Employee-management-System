package com.anjaniy.employeemanagementsystem.services;

import com.anjaniy.employeemanagementsystem.models.Employee;
import com.anjaniy.employeemanagementsystem.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

private final EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
