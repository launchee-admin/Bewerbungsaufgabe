package com.kailange.bewerbung.bewerbungsaufgabe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSaveWeatherData() throws Exception {
        mockMvc.perform(post("/api/weather")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"timestamp\": \"2024-11-21T10:00:00\", \"location\": \"Berlin\", \"temperature\": 12.5, \"humidity\": 85.0 }"))
                .andExpect(status().isOk());
    }
}
