package com.mappings.employeeJPQL.dao;

import com.mappings.employeeJPQL.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer> {


    @Query(value = "select * from department where department-name=?1",nativeQuery = true)
    Department getDepartmentidByName(String name);

    @Transactional
    @Modifying
    @Query(value = "Update Department Set departmentName=?2 where departmentId=?1")
    Department UpdateDepartmentidByName(Integer id,String name);
}
