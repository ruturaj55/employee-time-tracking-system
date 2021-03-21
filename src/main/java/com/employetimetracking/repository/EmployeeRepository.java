package com.employetimetracking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employetimetracking.model.Employee;

/**
 * @author Ruturaj Shinde
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	/**
	 * @param email
	 * @return list of employees searched by email id id
	 */
	List<Employee> findByEmail(String email);

}
