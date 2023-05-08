package com.mappings.employeeJPQL.controller;

import com.mappings.employeeJPQL.dao.DepartmentDao;
import com.mappings.employeeJPQL.entity.Employee;
import com.mappings.employeeJPQL.exception.EmployeeException;
import com.mappings.employeeJPQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentDao departmentDao;


    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp){
        if(getEmployeeByDepartment(emp.getDepartment().getDepartmentName()).isEmpty()){
            employeeService.addEmployee(emp);
        }else{
            emp.setDepartment(departmentDao.getDepartmentidByName(emp.getDepartment().getDepartmentName()));
            employeeService.addEmployee(emp);
        }


        return employeeService.addEmployee(emp);
    }
    @GetMapping("/employee/{empId}")
    public Employee GetEmployee(@PathVariable Integer empId){
    return employeeService.getEmployee(empId);
    }
    @PutMapping("/employee/{id}")
    public Integer UpdateEmployee(@PathVariable Integer id, @RequestBody Employee emp){
        Integer e=0;
        try {
             e = employeeService.updateEmployee(id,emp);
        } catch (EmployeeException e1) {
            System.out.println(e1.getMessage());
        }
        return e;
    }
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        try {
            employeeService.deleteEmployee(id);
        } catch (EmployeeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/employee/department/{Name}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String Name){
        return employeeService.getEmployeeByDepartmentName(Name);
    }
    @GetMapping("/employee/Name/{Name}")
    public List<Employee> GetEmployeeByName(@PathVariable String Name){
        return employeeService.getEmployeeByName(Name);
    }

}
