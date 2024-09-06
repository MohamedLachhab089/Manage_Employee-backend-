package com.med.employee_manager.repository;

import com.med.employee_manager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(long id);
}
