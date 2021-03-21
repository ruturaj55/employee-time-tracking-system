package com.employetimetracking.services;
import java.util.List;

import com.employetimetracking.model.Employee;

/**
 * @author Ruturaj Shinde
 * 
 * EmployeeService interface
 */
public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(long eid);

	// public Employee getEmployeeByEmail(String email);

	public List<Employee> getEmployeeByEmail(String email);

	public void addEmployee(Employee emp);

	public void updateEmplyee(Employee emp);

	public void deletEmployee(long eid);

}
