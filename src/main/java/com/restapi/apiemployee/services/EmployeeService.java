package com.restapi.apiemployee.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restapi.apiemployee.entity.Employee;
import com.restapi.apiemployee.mapper.EmployeeMapper;
import com.restapi.apiemployee.repository.EmployeeRepository;
import com.restapi.apiemployee.request.EmployeeRequest;
import com.restapi.apiemployee.response.DataResponse;
import com.restapi.apiemployee.response.EmployeeResponse;
import com.restapi.apiemployee.response.ResponseApi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeInterface{

    private final EmployeeRepository employeeRepository;
    @Override
    public ResponseEntity<ResponseApi> createData(EmployeeRequest request) {
       Employee employee=EmployeeMapper.toEmployee(request);
       employeeRepository.save(employee);
       return new ResponseEntity<>(new ResponseApi("success", true),HttpStatus.CREATED);
    
    }
    @Override
    public ResponseEntity<DataResponse> showData(int pagenumber, int pagesize) {
        Pageable pageable=PageRequest.of(pagenumber, pagesize, Sort.by(Direction.DESC, "id"));
        Page<Employee> page=employeeRepository.findAll(pageable);
        List<EmployeeResponse> list=new ArrayList<>();
        for(Employee employee:page){
            EmployeeResponse employeeResponse=new EmployeeResponse(
                employee.getId(),employee.getFirstName(),
                employee.getLastName(),employee.getPostion(),employee.getSalary());
            list.add(employeeResponse);
        }
        return new ResponseEntity<>(new DataResponse("success", true, list),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseApi> updateData(Integer id, EmployeeRequest request) {
        if(!employeeRepository.existsById(id)){
            return new ResponseEntity<>(new ResponseApi("ID invalid", false),HttpStatus.NOT_FOUND);
        }
        Employee employee=employeeRepository.findById(id).get();
        EmployeeMapper.updateEmployee(employee,request);
        employeeRepository.save(employee);
        return new ResponseEntity<>(new ResponseApi("success", true), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseApi> deleteData(Integer id) {
        if(!employeeRepository.existsById(id)){
            return new ResponseEntity<>(new ResponseApi("ID invalid", false),HttpStatus.NOT_FOUND);
        }
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success", true), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> searchByFirstname(String firstname) {
        Employee employee=employeeRepository.findByFirstName(firstname);
       if(employee ==null){
            return new ResponseEntity<>(new ResponseApi("data tidak ditemukan", true),HttpStatus.NOT_FOUND);
       }
       List<EmployeeResponse> list=new ArrayList<>();
       EmployeeResponse employeeResponse=new EmployeeResponse(
        employee.getId(), employee.getFirstName(),
        firstname, employee.getLastName(), employee.getSalary());
       list.add(employeeResponse);
       return new ResponseEntity<>(new DataResponse("success", true, list),HttpStatus.OK);
    }

    
}
