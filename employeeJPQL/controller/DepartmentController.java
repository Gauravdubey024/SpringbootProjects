package com.mappings.employeeJPQL.controller;

import com.mappings.employeeJPQL.dao.DepartmentDao;
import com.mappings.employeeJPQL.entity.Department;
import com.mappings.employeeJPQL.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentDao departmentDao;

    @PostMapping("/department")
    public Department addEmployee(@RequestBody Department d){
        return departmentDao.save(d);
    }
    @GetMapping("/department/{id}")
    public Department GetDepartment(@PathVariable Integer Id){
        return departmentDao.findById(Id).get();
    }
    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable Integer Id){
         departmentDao.deleteById(Id);
    }
    @PutMapping("/department/{id}")
    public void updateDepartment(@PathVariable Integer Id,@RequestBody Department department){
        departmentDao.UpdateDepartmentidByName(Id,department.getDepartmentName());
    }
}
