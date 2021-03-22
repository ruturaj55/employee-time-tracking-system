package com.employetimetracking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employetimetracking.model.Employee;
import com.employetimetracking.services.EmployeeService;

/**
 * @author Ruturaj Shinde
 *
 */
@Controller
/* @RestController */
public class EmployeeController {

	/**
	 * Inject EmployeeService to controller
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * its a home page containing list of Employee
	 * 
	 * method call on "/home" action request
	 * 
	 * return available employee list
	 */
	@GetMapping("/home")
	public String landOnHomePage(Model model) {
		model.addAttribute("empList", employeeService.getAllEmployee());
		return "home";

	}

	/**
	 * its a new employee form page takes input data for employee
	 * 
	 * method call on "/newEmployeForm" action request
	 * 
	 * return new employee form page
	 */
	@GetMapping("/newEmployeForm")
	public String newEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	/**
	 * its a employee save operation
	 * 
	 * method call on "/saveEmployee" action request
	 * 
	 * return available employee list with new added employee
	 */
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.addEmployee(emp);
		return "redirect:/home";
	}

	/**
	 * its a employee update form
	 * 
	 * method call on "/updateForm/{eid}" action request
	 * 
	 * return update form with selected employee data
	 */
	@GetMapping("/updateForm/{eid}")
	private String showUpdateForm(@PathVariable long eid, Model model) {
		Employee employee = employeeService.getEmployeeById(eid);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	/**
	 * its a employee delete operation
	 * 
	 * method call on "/deleteForm/{eid}" action request
	 * 
	 * return available employee list after deleting selected employee
	 */
	@GetMapping("/deleteForm/{eid}")
	public String deleteEmployee(@PathVariable long eid) {
		employeeService.deletEmployee(eid);
		return "redirect:/home";
	}

	/**
	 * its a employee search form with email id input
	 * 
	 * method call on "/searchbyemail" action request
	 * 
	 * return employee search by email form
	 */
	@GetMapping("/searchbyemail")
	public String searchByEmailForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "searchbyemail";
	}

	/**
	 * its a employee search operation with email id input
	 * 
	 * method call on "/searchbyemaildata" action request
	 * 
	 * return available employee list with email search
	 */
	@GetMapping("/searchbyemaildata")
	private String getEmployeeByEmail(@ModelAttribute("employee") Employee emp, Model model) {
		String email = emp.getEmail();
		model.addAttribute("empList", employeeService.getEmployeeByEmail(email));
		return "employeebyemail";
	}

	/**
	 * its a employee save operation with employee email id input
	 * 
	 * method call on "/saveEmployeeFromEmailSearch" action request
	 * 
	 * return available employee list with email search
	 */
	@PostMapping("/saveEmployeeFromEmailSearch")
	public String saveEmployeeFromEmailSearch(@ModelAttribute("employee") Employee emp, Model model) {
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		employeeService.addEmployee(emp);
		model.addAttribute("empList", empList);
		return "employeebyemail";
	}

	/**
	 * its a employee update form of employee searched by email
	 * 
	 * method call on "/updateFormSearchByEmail/{eid}" action request
	 * 
	 * return available employee list after updating employee searched by email
	 */
	@GetMapping("/updateFormSearchByEmail/{eid}")
	private String showUpdateFormSearchByEmail(@PathVariable long eid, Model model) {
		Employee employee = employeeService.getEmployeeById(eid);
		model.addAttribute("employee", employee);
		return "update_employee_search_by_email";
	}

}
