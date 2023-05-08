package com.mappings.employeeJPQL.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import java.util.List;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Department {

        @Id
        private Integer departmentId;
        private String departmentName;
        @JsonBackReference
        @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
        List<Employee> employees;



    }
