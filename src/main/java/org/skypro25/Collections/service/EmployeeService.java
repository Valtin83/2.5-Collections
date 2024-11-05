package org.skypro25.Collections.service;

import org.skypro25.Collections.employee.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee fine(String firstName, String lastName);

    Map<String, String> allEmployee();
}