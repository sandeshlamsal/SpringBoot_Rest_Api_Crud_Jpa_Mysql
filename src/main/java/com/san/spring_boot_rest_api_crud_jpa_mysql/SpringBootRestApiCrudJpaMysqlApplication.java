package com.san.spring_boot_rest_api_crud_jpa_mysql;

import com.san.spring_boot_rest_api_crud_jpa_mysql.entity.Employee;
import com.san.spring_boot_rest_api_crud_jpa_mysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//C
public class SpringBootRestApiCrudJpaMysqlApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiCrudJpaMysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e1=new Employee((long) 1,"John","black","john@gmail.com");
        Employee e2=new Employee((long) 2,"Jacky","brown","jacky@gmail.com");
        employeeRepository.save(e1);
        employeeRepository.save(e2);
    }
}
