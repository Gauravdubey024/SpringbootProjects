package com.mappings.employeeJPQL.service;

import com.mappings.employeeJPQL.entity.Employee;
import com.mappings.employeeJPQL.exception.EmployeeException;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee emp);

    public List<Employee> getEmployeeByDepartmentName(String name);

    public Employee getEmployee(Integer id);


    public List<Employee> getEmployeeByName(String name);

    public Integer updateEmployee(Integer id, Employee emp) throws EmployeeException;

    public Boolean deleteEmployee(Integer id) throws EmployeeException;
}
