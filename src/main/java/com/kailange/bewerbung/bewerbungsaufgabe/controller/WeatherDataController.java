package com.kailange.bewerbung.bewerbungsaufgabe.controller;

import com.kailange.bewerbung.bewerbungsaufgabe.Service.WeatherDataService;
import com.kailange.bewerbung.bewerbungsaufgabe.WeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {
    private final WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    // Endpunkt: Wetterdaten speichern
    @PostMapping
    public ResponseEntity<WeatherData> saveWeatherData(@RequestBody WeatherData weatherData) {
        WeatherData savedData = weatherDataService.saveWeatherData(weatherData);
        return ResponseEntity.ok(savedData);
    }

    // Endpunkt: Alle Wetterdaten abrufen
    @GetMapping
    public ResponseEntity<List<WeatherData>> getAllWeatherData() {
        List<WeatherData> weatherDataList = weatherDataService.getAllWeatherData();
        return ResponseEntity.ok(weatherDataList);
    }

    // Endpunkt: Wetterdaten nach ID abrufen
    @GetMapping("/{id}")
    public ResponseEntity<WeatherData> getWeatherDataById(@PathVariable Long id) {
        WeatherData weatherData = weatherDataService.getWeatherDataById(id);
        if (weatherData != null) {
            return ResponseEntity.ok(weatherData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
