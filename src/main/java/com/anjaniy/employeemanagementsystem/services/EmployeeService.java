package com.anjaniy.employeemanagementsystem.services;

import com.anjaniy.employeemanagementsystem.models.Employee;
import com.anjaniy.employeemanagementsystem.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

private final EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Transactional
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;

        if(optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }
        else{
            throw new RuntimeException("Employee Not Found For Given ID: " + id);
        }
        return employee;
    }
}

