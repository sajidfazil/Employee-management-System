package com.anjaniy.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String employeeId;

    private String firstName;

    private String lastName;

    private String departmentName;

    private String designation;

    private String location;

    private String employeeType;

    private String email;

    private String contactNo;
}
