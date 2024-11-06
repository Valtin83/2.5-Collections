package org.skypro25.Collections.service;

import org.skypro25.Collections.employee.Employee;
import org.skypro25.Collections.exception.EmployeeAlreadyAddedException;
import org.skypro25.Collections.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, String> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getKeyFullName())) {
            throw new EmployeeAlreadyAddedException("Работник уже в списке");
        }
        employees.put(employee.getKeyFullName(), String.valueOf(employee));
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getKeyFullName())) {
            employees.remove(employee.getKeyFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("Работника нет в списке");
    }

    @Override
    public Employee fine(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getKeyFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("Работника нет в списке");
    }

    @Override
    public Map<String, String> allEmployee() {
        return Collections.unmodifiableMap(employees);
    }
}

