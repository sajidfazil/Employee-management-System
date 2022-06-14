package com.anjaniy.employeemanagementsystem.controllers;

import com.anjaniy.employeemanagementsystem.models.Employee;
import com.anjaniy.employeemanagementsystem.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Display All The Employees:
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index.html";
    }

    //
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        //Create model Attribute To Bind The Form Data.
        model.addAttribute("employee", employee);
        return "add-employee.html";
    }
}
