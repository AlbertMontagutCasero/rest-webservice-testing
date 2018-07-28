package com.albert.montagut.casero.rest.model;

import java.util.Date;

public class Employee
{
	private String firstName;
	private String lastName;
	private String email;
	private Integer employeeId;
	private java.util.Date hireDate;
	// Getters and Setter for the above properties are not
	// shown in this code snippet to save space

	public Employee()
	{

	}

	public Employee(String firstName, String lastName, String email, Integer employeeId, Date hireDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.hireDate = hireDate;
	}

	public Employee(String firstName, String lastName, Integer employeeId, Date hireDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.hireDate = hireDate;
	}

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Integer getEmployeeId()
	{
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId)
	{
		this.employeeId = employeeId;
	}
	public java.util.Date getHireDate()
	{
		return hireDate;
	}
	public void setHireDate(java.util.Date hireDate)
	{
		this.hireDate = hireDate;
	}


	@Override
	public String toString()
	{
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", employeeId="
					 + employeeId + ", hireDate=" + hireDate + "]";
	}



}
