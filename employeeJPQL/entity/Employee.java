package com.mappings.employeeJPQL.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer employeeId;
        private String employeeFirstName;
        private String employeeLastName;
        private String employeeBirthDate;
        private String employeeCellPhone;

        @ManyToOne(cascade = CascadeType.ALL)
        private Department department;
    }

