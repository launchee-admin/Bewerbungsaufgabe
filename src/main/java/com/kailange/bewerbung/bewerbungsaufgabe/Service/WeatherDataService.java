package com.kailange.bewerbung.bewerbungsaufgabe.Service;

import com.kailange.bewerbung.bewerbungsaufgabe.WeatherData;
import com.kailange.bewerbung.bewerbungsaufgabe.repository.WeatherDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;

    public WeatherDataService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    // Speichert Wetterdaten
    public WeatherData saveWeatherData(WeatherData weatherData) {
        return weatherDataRepository.save(weatherData);
    }

    // Ruft alle Wetterdaten ab
    public List<WeatherData> getAllWeatherData() {
        return weatherDataRepository.findAll();
    }

    // Ruft Daten nach ID ab
    public WeatherData getWeatherDataById(Long id) {
        return weatherDataRepository.findById(id).orElse(null);
    }
}
