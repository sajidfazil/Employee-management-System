package com.anjaniy.employeemanagementsystem.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
