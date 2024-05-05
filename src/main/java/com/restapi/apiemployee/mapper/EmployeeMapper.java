package com.restapi.apiemployee.mapper;

import com.restapi.apiemployee.entity.Employee;
import com.restapi.apiemployee.request.EmployeeRequest;

public class EmployeeMapper {
    
    public static Employee toEmployee(EmployeeRequest request){
        Employee employee=new Employee();
        employee.setFirstName(request.getFirstname());
        employee.setLastName(request.getLastname());
        employee.setPostion(request.getPosition());
        employee.setSalary(request.getSalary());
        return employee;
    }

    public static void updateEmployee(Employee employee, EmployeeRequest request) {
        employee.setFirstName(request.getFirstname());
        employee.setLastName(request.getLastname());
        employee.setPostion(request.getPosition());
        employee.setSalary(request.getSalary());
    }
}
