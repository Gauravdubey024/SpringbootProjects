package com.mappings.employeeJPQL.dao;

import com.mappings.employeeJPQL.entity.Department;
import com.mappings.employeeJPQL.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    /*@Query("Insert Into Employee(employeeId,employeeFirstName,employeeLastName,employeeBirthDate,employeeCellPhone,department)VALUES(?1,?2,?3,?4,?5,?6)")
    Employee insertEmployee(Integer id, String first, String last, String dob, String phone, Department d);*/

    @Transactional
    @Modifying
    @Query("Update Employee Set employeeFirstName=?2,employeeLastName=?3,employeeBirthDate=?4,employeeCellPhone=?5,department=?6 where employeeId=?1")
    Integer updateEmployee(Integer id, String first, String last, String dob, String phone, Department d);
//Boolean deleteEmployee(Integer id);

//Employee getEmployee(Integer id);

    @Query(value ="select e from Employee e where department = (select departmentId from Department where departmentName=?1)")
    List<Employee> getEmployeeByDepartmentName(String name);

    @Query(value ="select e from Employee e where employeeFirstName= ?1 ")
    List<Employee> getEmployeeByName(String name);

    @Transactional
    @Modifying
    @Query(value ="Delete Employee e where employeeId= ?1 ")
    Integer deleteEmployeeById(Integer id);
}
