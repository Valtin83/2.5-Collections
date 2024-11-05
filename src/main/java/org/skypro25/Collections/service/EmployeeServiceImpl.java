package org.skypro25.Collections.service;

import org.skypro25.Collections.employee.Employee;
import org.skypro25.Collections.exception.EmployeeAlreadyAddedException;
import org.skypro25.Collections.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, String> employeeMap;

    public EmployeeServiceImpl(Map<String, String> employeeMap) {
        this.employeeMap = employeeMap;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Работник уже в списке");

        }
        employeeMap.put(key, String.valueOf(employee));
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            employeeMap.remove(key);
            return employee;
        }
        throw new EmployeeNotFoundException("Работника нет в списке");
    }

    @Override
    public Employee fine(String firstName, String lastName) {
        String key = firstName + " " + lastName;
        Employee employee = new Employee(firstName, lastName);

        if (employeeMap.containsKey(key)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Работника нет в списке");
    }

    @Override
    public Map<String, String> allEmployee() {
        return Collections.unmodifiableMap(employeeMap);
    }
}

