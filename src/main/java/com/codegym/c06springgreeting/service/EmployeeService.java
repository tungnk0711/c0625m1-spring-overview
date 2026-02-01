package com.codegym.c06springgreeting.service;

import com.codegym.c06springgreeting.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    private static Map<Long, Employee> employees;
    static {
        employees = new HashMap<>();
        employees.put(1L, new Employee(1, "Nguyen Khac Nhat", "IT", 30L));
        employees.put(2L, new Employee(2, "Dang Huy Hoa", "IT", 35L));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee findById(long id) {
        Employee e = employees.get(id);
        return e;
    }
}
