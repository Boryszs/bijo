# Bijo Movies

Aplikacja Spring Boot (Java 17, H2 w pamięci) z REST API do zarządzania listą filmów oraz prostym frontendem.

## Dokumentacja API

Dokumentacja Swagger (OpenAPI 3) jest dostępna na SwaggerHub:

**https://app.swaggerhub.com/apis/atartarnow/movies/1.0.0**

| Metoda | Ścieżka                  | Opis                                   |
|--------|--------------------------|----------------------------------------|
| GET    | `/api/movies`            | Lista filmów (od najnowszych)          |
| POST   | `/api/movies`            | Dodanie filmu                          |
| GET    | `/api/movies/{movieId}`  | Szczegóły filmu (tytuł, ID YouTube)    |
| DELETE | `/api/movies/{movieId}`  | Usunięcie filmu                        |

## Uruchomienie

```bash
mvn spring-boot:run
```

Aplikacja startuje na `http://127.0.0.1:8080`, frontend jest pod `http://127.0.0.1:8080/movies.html`.
