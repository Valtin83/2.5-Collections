package org.skypro25.Collections;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    // Создаем список сотрудников
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Сидор", "Сидоров"),
            new Employee("Николай", "Кузнецов"),
            new Employee("Семен", "Семенов")
    ));

    private static final int MAX_EMPLOYEES = 10;

    @GetMapping("/add")
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме.");
        }

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен.");
        }
        employees.add(employee);
        return employee;
    }

    @GetMapping
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }

    @GetMapping
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
