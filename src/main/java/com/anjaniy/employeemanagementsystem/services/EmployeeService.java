package com.anjaniy.employeemanagementsystem.services;

import com.anjaniy.employeemanagementsystem.dto.EmployeeDto;
import com.anjaniy.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.anjaniy.employeemanagementsystem.models.Employee;
import com.anjaniy.employeemanagementsystem.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public void saveEmployee(EmployeeDto employeeDto){
        employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
    }

    @Transactional
    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found For Given ID:" + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Transactional
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}

