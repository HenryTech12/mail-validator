package com.validator.test.service;

import com.validator.test.dto.*;
import java.net.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.*;
import java.net.http.*;

import com.fasterxml.jackson.core.type.TypeReference;
@Service
public class EmailValidatorService
{
	@Value("${validator-url}")
	private String url;
	private HttpClient httpClient;
	@Value("${validator-api}")
	private String apiKey;
	private ObjectMapper objectMapper;


	private Logger logger = LoggerFactory.getLogger(EmailValidatorService.class);

	public EmailValidatorService() {
	    httpClient = HttpClient.newHttpClient();
		objectMapper = new ObjectMapper();
	}

	public Validator readContent(String email) {
     try {
		String value = url.concat(email);
		HttpRequest request =  HttpRequest.newBuilder().uri(new URI(value))
			.header("x-rapidapi-host", "mailcheck.p.rapidapi.com")
			.header("x-rapidapi-key",apiKey)
			.GET()
			.build();
		HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
		 System.out.println(response.toString());
		 System.out.println(response.body());
		Validator validator = objectMapper.readValue(response.body() , new TypeReference<Validator>(){});
		logger.info("result: {}",validator);
		return validator;
	 }
     catch(Exception e) { e.printStackTrace(); logger.error(e.getMessage()); }
     return new Validator();
	}
	
}
