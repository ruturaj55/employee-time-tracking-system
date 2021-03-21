package com.employetimetracking.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ruturaj Shinde
 *
 *Entity class for employee table in database
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	private String email;
	private String name;
	private String department;
	private Date inDate;
	private Date outDate;
	private Time inTime;
	private Time outTime;

	/**
	 * Employee no-arg constructor
	 */
	public Employee() {
	}

	/**
	 * Employee parameterized constructor
	 * 
	 * @param eid
	 * @param email
	 * @param name
	 * @param department
	 * @param inDate
	 * @param outDate
	 * @param inTime
	 * @param outTime
	 */
	public Employee(Long eid, String email, String name, String department, Date inDate, Date outDate, Time inTime,
			Time outTime) {
		super();
		this.eid = eid;
		this.email = email;
		this.name = name;
		this.department = department;
		this.inDate = inDate;
		this.outDate = outDate;
		this.inTime = inTime;
		this.outTime = outTime;
	}

	/**
	 * @return eid
	 */
	public Long getEid() {
		return eid;
	}

	/**
	 * @param eid
	 */
	public void setEid(Long eid) {
		this.eid = eid;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return inDate
	 */
	public Date getInDate() {
		return inDate;
	}

	/**
	 * @param inDate
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	/**
	 * @return outDate
	 */
	public Date getOutDate() {
		return outDate;
	}

	/**
	 * @param outDate
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	/**
	 * @return inTime
	 */
	public Time getInTime() {
		return inTime;
	}

	/**
	 * @param inTime
	 */
	public void setInTime(Time inTime) {
		this.inTime = inTime;
	}

	/**
	 * @return outTime
	 */
	public Time getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime
	 */
	public void setOutTime(Time outTime) {
		this.outTime = outTime;
	}

}
