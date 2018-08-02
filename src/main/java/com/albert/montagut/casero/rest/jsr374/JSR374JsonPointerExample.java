package com.albert.montagut.casero.rest.jsr374;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class JSR374JsonPointerExample {

	private static final Logger logger = Logger.getLogger(JSR374JsonPointerExample.class.getName());

	public static void main(String[] args) throws IOException {		
		logger.setLevel(Level.INFO);

		String jsonFileName = "/emp.json";
		InputStream inputStream = JSR374JsonPointerExample.class.getResourceAsStream(jsonFileName);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");

		JsonReader jsonReader = Json.createReader(reader);
		JsonObject jsonObject = (JsonObject) jsonReader.read();

		JsonPointer pointer = Json.createPointer("/firstName");

		JsonValue value = pointer.getValue(jsonObject);

		logger.log(Level.INFO, "Fetched First Name:{0}", value.toString());

		JsonValue replaceFirstName = Json.createValue("Mike");
		jsonObject = pointer.add(jsonObject, replaceFirstName);

		value = pointer.getValue(jsonObject);

		logger.log(Level.INFO, "Modified First Name:{0}", value.toString());
		
	}
}
