package com.employetimetracking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employetimetracking.model.Employee;
import com.employetimetracking.repository.EmployeeRepository;

/**
 * @author Ruturaj Shinde
 *
 *         EmployeeService interface implementation class
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*
	 * @Autowired
	 * 
	 * RestTemplate restTemplate;
	 */
	
	/**
	 * Inject EmployeeRepository to EmployeeServiceImpl
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * its a get all employees list operation available in database
	 * 
	 * method call on getAllEmployee
	 * 
	 * return available employee list
	 */
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return empList;
	}

	/**
	 * its a get all employee operation available in database by email id input
	 * 
	 * method call on getEmployeeByEmail
	 * method call on getEmployeeByEmail We also can use external service to get
	 * data on other system by calling URL of it
	 * 
	 * return available employee list with email search
	 */
	@Override
	public List<Employee> getEmployeeByEmail(String email) {
		
		/*
		 * providing implementation for external service call
		 * List<Employee> empList = null; JSONPObject[] jsonObjarray = null; String
		 * inEmail = email; Employee forObject =
		 * restTemplate.getForObject("http://localhost:8080/records/" + inEmail,
		 * Employee.class); empList.add(forObject);
		 */
		
		
		List<Employee> empList = null;
		empList = employeeRepository.findByEmail(email);

		if (null != empList) {
			return empList;
		}
		return empList;

	}

	/**
	 * its a employee save operation to database table
	 * method call on addEmployee We also can use external service to SAVE NE EMPLOYEE OBJ
	 * data on other system by calling URL of it 
	 * method call on addEmployee with employee obj as input
	 * 
	 */
	@Override
	public void addEmployee(Employee emp) {
		
		/*
		 * providing implementation for external service save call
		 * Employee emp=new Employee(); 
		 * restTemplate.getForObject("http://localhost:8080/emp",
		  Employee.class);
		 */
		
		employeeRepository.save(emp);
	}

	/**
	 * its a employee update operation from database table
	 * 
	 * method call on updateEmplyee with employee obj as input
	 * 
	 */
	@Override
	public void updateEmplyee(Employee emp) {
		employeeRepository.save(emp);
	}

	/**
	 * its a get employee operation available in database by eid as input
	 * 
	 * method call on getEmployeeById with eid input
	 * 
	 * return available employee with eid search
	 */

	@Override
	public Employee getEmployeeById(long eid) {
		Optional<Employee> optional = employeeRepository.findById(eid);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee is not present with id :" + eid);
		}

		return employee;

	}

	/**
	 * its a employee delete operation from database table
	 * 
	 * method call on deletEmployee with employee eid input
	 * 
	 */
	@Override
	public void deletEmployee(long eid) {
		employeeRepository.deleteById(eid);
	}

}
