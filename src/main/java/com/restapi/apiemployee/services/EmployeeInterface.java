package com.restapi.apiemployee.services;
/**
 * EmployeeInterface
 */

import org.springframework.http.ResponseEntity;

import com.restapi.apiemployee.request.EmployeeRequest;
import com.restapi.apiemployee.response.DataResponse;
import com.restapi.apiemployee.response.ResponseApi;

public interface EmployeeInterface {
    ResponseEntity<ResponseApi> createData(EmployeeRequest request);   
    ResponseEntity<DataResponse> showData(int pagenumber,int pagesize);
    ResponseEntity<ResponseApi> updateData(Integer id,EmployeeRequest request);
    ResponseEntity<ResponseApi> deleteData(Integer id);
    ResponseEntity<Object> searchByFirstname(String firstname);
}