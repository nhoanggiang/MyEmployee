package com.nhoanggiang.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhoanggiang.demo.model.Employee;
import com.nhoanggiang.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> search(String q) {
		return employeeRepository.findByNameContaining(q);
	}

	@Override
	public Optional<Employee> findOne(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void save(Employee contact) {
		employeeRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
