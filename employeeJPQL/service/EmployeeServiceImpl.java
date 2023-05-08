package com.mappings.employeeJPQL.service;

import com.mappings.employeeJPQL.dao.EmployeeDao;
import com.mappings.employeeJPQL.entity.Employee;
import com.mappings.employeeJPQL.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Employee addEmployee(Employee emp) {
        return employeeDao.save(emp);
        //return employeeDao.insertEmployee(emp.getEmployeeId(),emp.getEmployeeFirstName(),emp.getEmployeeLastName(),emp.getEmployeeBirthDate(),emp.getEmployeeCellPhone(),emp.getDepartment());
    }

    @Override
    public List<Employee> getEmployeeByDepartmentName(String name) {
        return employeeDao.getEmployeeByDepartmentName(name);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeDao.findById(id).get();
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @Override
    public Integer updateEmployee(Integer id, Employee emp) throws EmployeeException {
        if (employeeDao.findById(id).isPresent()) {
            //return employeeDao.save(emp);
            return employeeDao.updateEmployee(id,emp.getEmployeeFirstName(),emp.getEmployeeLastName(),emp.getEmployeeBirthDate(),emp.getEmployeeCellPhone(),emp.getDepartment());
        } else {
            throw new EmployeeException("Employee Nor Found To Update!!");
        }
    }

        @Override
        public Boolean deleteEmployee (Integer id) throws EmployeeException {
            Boolean isDeleted = false;
            if (employeeDao.findById(id).isPresent()) {
                employeeDao.deleteEmployeeById(id);
                isDeleted = true;
            } else {
                throw new EmployeeException("Employee does not Exist");
            }

            return isDeleted;
        }
    }
