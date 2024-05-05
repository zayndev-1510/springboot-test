package com.restapi.apiemployee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Table(name = "tbl_employee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * Employee
 */
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="firstname",length=30)
    private String firstName;

    @Column(name = "lastname",length = 30)
    private String lastName;

    @Column(name = "position",length = 30)
    private String postion;

    @Column(name="salary")
    private Double salary;

}