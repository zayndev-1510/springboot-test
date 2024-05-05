package com.restapi.apiemployee.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.apiemployee.request.EmployeeRequest;
import com.restapi.apiemployee.response.DataResponse;
import com.restapi.apiemployee.response.ResponseApi;
import com.restapi.apiemployee.services.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class Employee {
    
    private final EmployeeService employeeService;

    @GetMapping("/{a}/{b}")
   public ResponseEntity<DataResponse> show(@PathVariable("a") int pagenumber,@PathVariable("b") int pagesize){
        return employeeService.showData(pagenumber, pagesize);
   }
    
   @PostMapping
   public ResponseEntity<ResponseApi> create(@RequestBody EmployeeRequest request){
    return employeeService.createData(request);
   }

   @PutMapping("/{a}")
   public ResponseEntity<ResponseApi> update(@PathVariable("a") Integer id,@RequestBody EmployeeRequest employeeRequest){
     return employeeService.updateData(id, employeeRequest);
   }

   @DeleteMapping("/{a}")
   public ResponseEntity<ResponseApi> delete(@PathVariable("a") Integer id){
     return employeeService.deleteData(id);
   }

   @GetMapping("/firstname/{a}")
   public ResponseEntity<Object> searchFirstname(@PathVariable("a") String firstname){
     return employeeService.searchByFirstname(firstname);
   }
   
    
}
