package com.albert.montagut.casero.rest.jsonb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import com.albert.montagut.casero.rest.model.Employee;

public class JsonBParserExample {
	public JsonBParserExample() {

	}

	private String JSON_READ_RESOURCE = "/emp-array.json";
	private String JSON_WRITE_RESOURCE = "src//main//resources//emp-array2.json";

	public void writerObjectsToJson(List<Employee> employees) {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		for (Employee employee : employees) {
			jsonArrayBuilder.add(Json.createObjectBuilder().add("employeeId", employee.getEmployeeId())
					.add("firstName", employee.getFirstName()).add("lastName", employee.getLastName())
					.add("email", employee.getEmail()).add("hireDate", employee.getHireDate().toString()));
		}

		JsonArray employeesArray = jsonArrayBuilder.build();

		try (OutputStream outputStream = new FileOutputStream(JSON_WRITE_RESOURCE);
				JsonWriter jsonWriter = Json.createWriter(outputStream);) {

			jsonWriter.writeArray(employeesArray);
			System.out.println("File written successfully ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> readerFromJsonToObjects() {
		List<Employee> employees = new ArrayList<>();
		// Get input stream for reading the specified resource.
		try (InputStream inputStream = getClass().getResourceAsStream(JSON_READ_RESOURCE);
				Reader reader = new InputStreamReader(inputStream, "UTF-8");
				JsonReader jsonReader = Json.createReader(reader);) {
			JsonArray readArray = jsonReader.readArray();

			for (JsonValue jsonValue : readArray) {
				if (JsonValue.ValueType.OBJECT == jsonValue.getValueType()) {
					JsonObject jsonObject = (JsonObject) jsonValue;
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date hireDate = simpleDateFormat.parse(jsonObject.getString("hireDate"));

					employees.add(new Employee(jsonObject.getString("firstName"), jsonObject.getString("lastName"),
							jsonObject.getString("email"), jsonObject.getInt("employeeId"), hireDate));
				}
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static void main(String[] args) {
		JsonBParserExample jsonBReader = new JsonBParserExample();
		List<Employee> employees = jsonBReader.readerFromJsonToObjects();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}

		jsonBReader.writerObjectsToJson(employees);
	}
}
