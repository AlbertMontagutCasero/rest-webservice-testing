package com.albert.montagut.casero.rest.gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.albert.montagut.casero.rest.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonExample
{
	public static void main(String[] args)
	{
		new GsonExample().readObjectJsonUsingGson();

	}

	private void readObjectJsonUsingGson()
	{
		// Get GsonBuilder object
		GsonBuilder gsonBuilder = new GsonBuilder();
		// Set date format for converting date presented in
		// form (in JSON data) to java.util.Date
		gsonBuilder.setDateFormat( "yyyy-MM-dd" );
		// Get gson object
		Gson gson = gsonBuilder.create();

		// Read the json input file with current class's class
		// loader emp.json contains JSON employee
		InputStream inputStream = getClass().getResourceAsStream( "/emp.json" );
		BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
		// Converts JSON string to Employee object
		Employee employee = gson.fromJson( reader, Employee.class );
		System.out.println( employee );
	}

	private void readListFromJsonUsingGson()
	{
	//Step 1: Read emp-array.json
		InputStream inputStream =
		getClass().getResourceAsStream("/emp-array.json");
		BufferedReader reader = new BufferedReader(new
		  InputStreamReader(inputStream));
		// Step 2: Define TypeToken
		// Define a  parameterized collection type to hold the List
		// of Employees returned by Gson::fromJSon method call.
		Type listType = new TypeToken<ArrayList<Employee>>(){}
		  .getType();
		//Step 3: Convert JSON array to List<Employee>
		//Generates list of employees by calling Gson::fromJson()
		Gson gson = new Gson();
		List<Employee> employees = gson.fromJson(reader, listType);
	}

}
