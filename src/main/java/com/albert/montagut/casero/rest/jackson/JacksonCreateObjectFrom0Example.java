package com.albert.montagut.casero.rest.jackson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.albert.montagut.casero.rest.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JacksonCreateObjectFrom0Example
{

	public static void main(String[] args) throws JsonParseException,
																				 JsonMappingException,
																				 IOException
	{
		createJacksonJsonObject();

		createListFromJsonObjectArray();
	}

	private static void createListFromJsonObjectArray() throws IOException,
																											JsonParseException,
																											JsonMappingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType( List.class, Employee.class );
		List< Employee > employees = objectMapper.readValue( new File( "src\\main\\resources\\emp-array.json" ),
																												 collectionType );

		for ( Employee employee : employees )
		{
			System.out.println( employee.toString() );
		}
	}

	private static void createJacksonJsonObject() throws IOException,
																								JsonParseException,
																								JsonMappingException
	{
		String jsonString = "{\" firstName\":\"John\",\"lastName\":\"Chen\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		// properties will store name and value pairs read from jsonString
		Map< String , String > properties =
																			objectMapper.readValue( jsonString, new TypeReference< Map< String , String > >()
																			{ //
																			} );

		System.out.println( properties.toString() );
	}
}
