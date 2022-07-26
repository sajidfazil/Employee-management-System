package com.anjaniy.employeemanagementsystem.models;

import com.anjaniy.employeemanagementsystem.enums.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee ID Is Required")
    private String employeeId;

    @NotBlank(message = "First Name Is Required!")
    private String firstName;

    @NotBlank(message = "Last Name Is Required!")
    private String lastName;

    @NotBlank(message = "Department Name Is Required!")
    private String departmentName;

    @NotBlank(message = "Designation Is Required!")
    private String designation;

    @NotBlank(message = "Location")
    private String location;

    @NotBlank(message = "Employee Type Is Required")
    private EmployeeType employeeType;

    @Email
    @NotBlank(message = "Email Address Is Required!")
    private String email;

    @NotBlank(message = "Contact Number Is Required")
    private String contactNo;
}
