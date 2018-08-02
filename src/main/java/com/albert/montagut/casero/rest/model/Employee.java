package com.albert.montagut.casero.rest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee
{


	@JsonProperty("firstName") private String firstName; //Alias anotation to properties.
	private String lastName;
	private String email;
	private Integer employeeId;
	private java.util.Date hireDate;

	public Employee()
	{

	}

	public Employee(String name, String lastName, String email, Integer employeeId, Date hireDate)
	{
		this.firstName = name;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.hireDate = hireDate;
	}

	public Employee(String name, String lastName, Integer employeeId, Date hireDate)
	{
		this.firstName = name;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.hireDate = hireDate;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFristName(String name)
	{
		this.firstName = name;
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
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", employeeId=" + employeeId
					 + ", hireDate=" + hireDate + "]";
	}

}
