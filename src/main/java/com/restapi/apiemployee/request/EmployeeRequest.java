package com.restapi.apiemployee.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequest {
    private String firstname;
    private String lastname;
    private String position;
    private Double salary;
}
