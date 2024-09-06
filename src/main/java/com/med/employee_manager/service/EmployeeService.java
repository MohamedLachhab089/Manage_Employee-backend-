package com.med.employee_manager.service;

import com.med.employee_manager.exception.UserNotFoundException;
import com.med.employee_manager.entity.Employee;
import com.med.employee_manager.repository.EmployeeRep;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRep employeeRep;

    @Autowired
    public EmployeeService(EmployeeRep employeeRep) {
        this.employeeRep = employeeRep;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRep.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRep.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRep.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRep.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRep.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

}
