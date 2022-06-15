package com.anjaniy.employeemanagementsystem.models;

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

    @NotBlank(message = "First Name Is Required!")
    private String firstName;

    @NotBlank(message = "Last Name Is Required!")
    private String lastName;

    @NotBlank(message = "Department Name Is Required!")
    private String departmentName;

    @Email
    @NotBlank(message = "Email Address Is Required!")
    private String email;

    private long contactNo;
}
