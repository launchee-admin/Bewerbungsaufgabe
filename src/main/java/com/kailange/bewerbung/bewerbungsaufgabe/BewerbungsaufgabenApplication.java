package com.kailange.bewerbung.bewerbungsaufgabe;
import com.kailange.bewerbung.bewerbungsaufgabe.service.DwdWeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class BewerbungsaufgabenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BewerbungsaufgabenApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner run(DwdWeatherService weatherService) {
        return args -> {
            System.out.println("Fetching weather data...");
            System.out.println(weatherService.fetchWeatherData());
        };
    }


}
