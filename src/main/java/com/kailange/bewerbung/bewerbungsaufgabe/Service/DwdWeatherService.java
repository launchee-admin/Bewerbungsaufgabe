package com.kailange.bewerbung.bewerbungsaufgabe.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DwdWeatherService {

    private final RestTemplate restTemplate;

    public DwdWeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JsonNode fetchWeatherData() {
        String url = "https://dwd.api.bund.dev/v2/stationOverview";
        return restTemplate.getForObject(url, JsonNode.class);
    }
}
