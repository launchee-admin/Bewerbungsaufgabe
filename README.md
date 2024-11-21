Trafficon Backend - Bewerbung
Beschreibung
Dies ist eine einfache Spring Boot-Anwendung, die es ermöglicht, Wetterdaten in eine PostgreSQL-Datenbank zu importieren und diese Daten über eine REST API abzurufen. Die Anwendung besteht aus den folgenden Hauptfunktionen:

Import von Wetterdaten in die Datenbank.
Abruf der gespeicherten Wetterdaten aus der Datenbank.
Features:
Datenimport via POST /api/weather.
Datenabruf via GET /api/weather.
Die Anwendung verwendet Docker und Docker Compose, um PostgreSQL in einem Container bereitzustellen.
Integration von DWD-Wetterdaten oder anderen externen APIs (optional).
Setup und Installation
1. Voraussetzungen:
Stelle sicher, dass Docker und Docker Compose auf deinem System installiert sind.

Docker: Installation
Docker Compose: Installation
2. Projekt herunterladen:
Klonen des Repositories:

bash
Code kopieren
git clone https://github.com/dein-benutzername/Trafficon.git
cd Trafficon
3. Docker und PostgreSQL starten:
Starte sowohl die Spring Boot-Anwendung als auch die PostgreSQL-Datenbank mit Docker Compose:

bash
Code kopieren
docker-compose up --build
Die Anwendung wird auf http://localhost:8080 und die PostgreSQL-Datenbank auf localhost:5432 verfügbar sein.

4. Datenbank initialisieren:
Die Datenbank wird beim ersten Start automatisch mit einer Tabelle für Wetterdaten erstellt. Das init.sql-Skript wird beim ersten Start ausgeführt, um alle notwendigen Tabellen zu erstellen.

5. Anwendung stoppen:
Um die Anwendung und die Datenbank zu stoppen:

bash
Code kopieren
docker-compose down
API-Endpunkte
1. POST /api/weather
Verwendet diesen Endpunkt, um Wetterdaten in die Datenbank zu importieren.

Beispiel-Request:

bash
Code kopieren
curl -X POST http://localhost:8080/api/weather \
    -H "Content-Type: application/json" \
    -d '{"timestamp": "2024-11-21T10:00:00", "location": "Berlin", "temperature": 12.5, "humidity": 85.0}'
Antwort:

json
Code kopieren
{
    "id": 1,
    "timestamp": "2024-11-21T10:00:00",
    "location": "Berlin",
    "temperature": 12.5,
    "humidity": 85.0
}
2. GET /api/weather
Verwendet diesen Endpunkt, um alle gespeicherten Wetterdaten abzurufen.

Beispiel-Request:

bash
Code kopieren
curl -X GET http://localhost:8080/api/weather
Antwort:

json
Code kopieren
[
    {
        "id": 1,
        "timestamp": "2024-11-21T10:00:00",
        "location": "Berlin",
        "temperature": 12.5,
        "humidity": 85.0
    }
]
Verwendete Technologien
Spring Boot: Für die Erstellung der RESTful API und der Geschäftslogik.
PostgreSQL: Für die Speicherung der Wetterdaten.
Docker: Zur Containerisierung der Anwendung und der Datenbank.
JUnit 5 & MockMvc: Für die Durchführung von Integrationstests und Unit-Tests.
Externe APIs und Datenquellen
Falls gewünscht, kann die Anwendung auch mit dem DWD-Wetter-API integriert werden, um Wetterdaten von einer öffentlichen Quelle zu beziehen.

DWD-Wetter-API: DWD API Dokumentation
Tests
Die Anwendung enthält Unit-Tests, um die Funktionsweise der Endpunkte und der Datenbankverbindung zu überprüfen.

Beispiel-Test für das Speichern von Wetterdaten:

java
Code kopieren
@Test
void testSaveWeatherData() throws Exception {
    mockMvc.perform(post("/api/weather")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"timestamp\": \"2024-11-21T10:00:00\", \"location\": \"Berlin\", \"temperature\": 12.5, \"humidity\": 85.0 }"))
            .andExpect(status().isOk());
}
Häufige Probleme
Verbindung zur Datenbank fehlgeschlagen: Vergewissere dich, dass Docker und PostgreSQL korrekt konfiguriert sind und die Container laufen.
API-Endpunkte funktionieren nicht: Überprüfe, ob Spring Boot korrekt gestartet wurde und auf localhost:8080 lauscht.
Weitere Informationen
Spring Boot Dokumentation: Spring Boot
Docker Dokumentation: Docker
PostgreSQL Dokumentation: PostgreSQL
