package com.nhoanggiang.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nhoanggiang.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	List<Employee> findByNameContaining(String q);

}
