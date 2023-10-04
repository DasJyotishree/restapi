package com.example.demo.ControllerLayer;

import com.example.demo.Employee;
import com.example.demo.Service.Layer.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") //access the class
public class    EmployeeController {

    private EmployeeService employeeService;

    @Autowired

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> GetEmp() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmpByid(@PathVariable("id") Long empid) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeByid(empid), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateEmp(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<String>("Record updated successfully", HttpStatus.FOUND);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Record deleted successfully", HttpStatus.FOUND);

    }
}

