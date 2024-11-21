package com.kailange.bewerbung.bewerbungsaufgabe.repository;

import com.kailange.bewerbung.bewerbungsaufgabe.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {}
