package com.anjaniy.employeemanagementsystem.controllers;

import com.anjaniy.employeemanagementsystem.models.Employee;
import com.anjaniy.employeemanagementsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Display All The Employees:
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index.html";
    }

    //Show New Employee Form:
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        //Create model Attribute To Bind The Form Data.
        model.addAttribute("employee", employee);
        return "add-employee.html";
    }

    //Save Employee To Database:
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //Save Employee To The Database:
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    //Show Employee Update Form:
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model){
        //Get Employee From The Service:
        Employee employee = employeeService.getEmployeeById(id);

        //Set Employee As A Model Attribute To Pre-Populate Form.
        model.addAttribute("employee", employee);
        return "update-employee.html";
    }

    //Delete Employee From Database:
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        //Delete Employee From The Database:
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
