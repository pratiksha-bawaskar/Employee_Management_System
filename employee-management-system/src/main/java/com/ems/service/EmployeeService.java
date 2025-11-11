package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee saveEmployee(Employee emp) {
        return repository.save(emp);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee emp) {
        return repository.findById(id).map(existing -> {
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setEmail(emp.getEmail());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
}
