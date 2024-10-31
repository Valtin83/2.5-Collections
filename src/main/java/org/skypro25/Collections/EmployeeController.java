package org.skypro25.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            throw e;
        }
    }

    @GetMapping("/remove")
    public ResponseEntity<Employee> removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.removeEmployee(firstName, lastName);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.findEmployee(firstName, lastName);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
