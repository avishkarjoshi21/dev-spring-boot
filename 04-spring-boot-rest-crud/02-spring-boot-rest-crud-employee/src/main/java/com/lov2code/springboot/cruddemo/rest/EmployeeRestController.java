package com.lov2code.springboot.cruddemo.rest;

import com.lov2code.springboot.cruddemo.entity.Employee;
import com.lov2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // quick and dirty: inject employee service
    final private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add "/employees/{employeeId}" endpoint and return a employee

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = getEmployee(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        // set Id of employee to 0 even if the id is passed in json so that always new employee entity will be created.
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {

        if(getEmployee(employee.getId()) == null) {
            throw new RuntimeException("Employee with id " + employee.getId() + " not found");
        }

        return employeeService.save(employee);
    }

    private Employee getEmployee(int employeeId) {
        return employeeService.findById(employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        Employee employee = getEmployee(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        employeeService.delete(employee);
        return "Employee with id " + employeeId + " deleted";
    }
}
