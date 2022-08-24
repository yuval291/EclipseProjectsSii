package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.models.ForeignExchange;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Map;

@Service
public class ForeignExchangeService {
	
	@Autowired
	ForeignExchange foreignExchange;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	@Scheduled(cron = "0 0 12 * * ?")
	public void getForeignExchange() throws IOException {
		foreignExchange = restTemplate.getForObject("https://api.exchangerate-api.com/v4/latest/ILS", ForeignExchange.class);
		System.out.println(foreignExchange);
	}
	
	public Double convert(String convertFrom, Double amount, String convertTo) {
        Map<String, Double> rates = foreignExchange.getRates();
        Double fromBase = amount / rates.get(convertFrom);
        Double convert = fromBase * rates.get(convertTo);
        
        return convert;
    }
	
}
