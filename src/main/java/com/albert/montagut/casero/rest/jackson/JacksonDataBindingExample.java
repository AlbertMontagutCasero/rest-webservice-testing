package com.albert.montagut.casero.rest.jackson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import com.albert.montagut.casero.rest.model.Employee;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JacksonDataBindingExample
{
	public static void main(String[] args) throws JsonParseException,
																				 JsonMappingException,
																				 IOException
	{
		//Employee objectFromJson = createObjectFromJson();
		//System.out.println( objectFromJson );

		// writeObjectJsonWithJackson();

		// parseJsonUsingStreams();

		readObjectFromJson();

	}

	private static void parseJsonUsingStreams() throws FileNotFoundException,
																							IOException,
																							JsonParseException,
																							JsonMappingException
	{
		OutputStream outputStream = new FileOutputStream( "emp-array3333.json" );
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator( outputStream, JsonEncoding.UTF8 );

		jsonGenerator.writeStartArray();
		List< Employee > employees = createListFromJsonObjectArray();
		for ( Employee employee : employees )
		{
			System.out.println( employee );
			jsonGenerator.writeStartObject();
			jsonGenerator.writeNumberField( "employeeId", employee.getEmployeeId() );
			jsonGenerator.writeStringField( "firstName", employee.getFirstName() );
			jsonGenerator.writeStringField( "lastName", employee.getLastName() );
			jsonGenerator.writeEndObject();

		}

		jsonGenerator.writeEndArray();
	}

	private static List< Employee > createListFromJsonObjectArray() throws IOException,
																																	JsonParseException,
																																	JsonMappingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType( List.class, Employee.class );
		return objectMapper.readValue( new File( "src\\main\\resources\\emp-array.json" ), collectionType );
	}

	private static void writeObjectJsonWithJackson() throws IOException,
																									 JsonGenerationException,
																									 JsonMappingException
	{
		Employee employee = new Employee( "Albert", "Montagut Casero", "Albert.montagut.Casero@gmail.com", 32, new Date() );
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue( new File( "emp2.json" ), employee );
	}

	private static Employee createObjectFromJson() throws IOException,
																								 JsonParseException,
																								 JsonMappingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue( new File( "src\\main\\resources\\emp.json" ), Employee.class );
	}

	private static void readObjectFromJson() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employee = objectMapper.readValue( new File( "src\\main\\resources\\emp.json" ), Employee.class );
		System.out.println( employee );
	}

}
