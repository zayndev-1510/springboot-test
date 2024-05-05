package com.restapi.apiemployee.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class EmployeeResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String position;
    private Double salary;
}
