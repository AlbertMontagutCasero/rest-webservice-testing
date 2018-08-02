package com.albert.montagut.casero.rest.jackson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonParserExample {
	public static void main(String[] args) throws IOException {
		JacksonParserExample jacksonParser = new JacksonParserExample();
		jacksonParser.parser();
	}

	private void parser() throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("/emp-array.json");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(inputStream);
		System.out.println(rootNode);

		if (rootNode.isArray()) {
			for (JsonNode objectNode : rootNode) {
				JsonNode emailNode = objectNode.path("email");

				// si algun mail estuviese vacio se rellenaria con un string aleatorio
				if (emailNode.textValue() != null) {
					String randomString = generateRandomString(30);
					((ObjectNode) objectNode).put("email", randomString);
				}
			}
		}
		// Write the modified tree to a json file
		objectMapper.writeValue(new File("emp-array4.json"), rootNode);
		if (inputStream != null) {
			inputStream.close();
		}
	}

	private String generateRandomString(int lenght) {
		int leftLimit = 97;
		int rightLimit = 122;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(lenght);
		for (int i = 0; i < lenght; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();

	}
}
