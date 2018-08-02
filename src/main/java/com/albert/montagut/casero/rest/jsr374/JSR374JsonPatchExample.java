package com.albert.montagut.casero.rest.jsr374;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPatch;
import javax.json.JsonPatchBuilder;
import javax.json.JsonReader;

public class JSR374JsonPatchExample {
	private static final Logger logger = Logger.getLogger(JSR374JsonPointerExample.class.getName());

	public static void main(String[] args) throws IOException {
		logger.setLevel(Level.INFO);

		String jsonFileName = "/emp.json";
		InputStream inputStream = JSR374JsonPointerExample.class.getResourceAsStream(jsonFileName);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");

		JsonReader jsonReader = Json.createReader(reader);
		JsonObject jsonObject = (JsonObject) jsonReader.read();

		logger.log(Level.INFO, "Input Employee:{0}", jsonObject.toString());

		JsonPatchBuilder patchBuilder = Json.createPatchBuilder();

		patchBuilder.add("/gender", "Male");
		patchBuilder.remove("/hireDate");

		JsonPatch patch = patchBuilder.build();
		jsonObject = patch.apply(jsonObject);

		logger.log(Level.INFO, "Output Employee:{0}", jsonObject.toString());
	}
}
