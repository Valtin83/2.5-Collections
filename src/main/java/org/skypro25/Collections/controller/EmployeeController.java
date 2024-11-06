package org.skypro25.Collections.controller;

import org.skypro25.Collections.employee.Employee;
import org.skypro25.Collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/fine")
    public Employee fineEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        return service.fine(firstName, lastName);
    }

    @GetMapping
    public Map<String, String> allEmployee() {
        return service.allEmployee();
    }
}

