package com.example.demo.Service.Layer;

import com.example.demo.Employee;

import java.util.List;

public interface EmployeeService {
     Employee saveEmployee(Employee employee);
          List<Employee>getAllEmployees();
           Employee getEmployeeByid(Long id);
           Employee updateEmployee(Long empid,Employee emp );
           void deleteEmployee(Long empid);


}
