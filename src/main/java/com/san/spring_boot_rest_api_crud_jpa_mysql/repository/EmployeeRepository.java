package com.san.spring_boot_rest_api_crud_jpa_mysql.repository;

import com.san.spring_boot_rest_api_crud_jpa_mysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
