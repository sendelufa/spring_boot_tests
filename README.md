# Демонстрация тестов в Spring Boot

В проекте найдете примеры юнит тестов, интеграционных тестов с
использованием JUnit 5, AssertJ, Mockito, Testcontainers.

## Используемые технологии

- Spring Boot 3
- Maven 3
- PostgreSQL
- MyBatis 3
- JUnit 5
- AssertJ
- Mockito
- Testcontainers
- Lombok

## Требования

### JDK 17

Проект использует синтаксис Java 17. Для локального запуска вам потребуется
установленный JDK 17.

### Docker
Для запуска тестов вам потребуется установленный и запущенный Docker.
Testcontainers требует запущенного сервиса Docker.

## Полезные команды

### Запуск контейнера с базой данных

```bash
docker run \
--detach \
--name=postgres-karasongs \
--env="POSTGRES_PASSWORD=g#e3yPfu" \
--publish 5432:5432 \
postgres
```

Пользователь для подключения к контейнеру `postgres`.

### Запросы API

Создание новой записи о музыкальной композиции

```bash
curl --request POST \
  --url http://localhost:8089/api/songs/ \
  --header 'Content-Type: application/json' \
  --data '{
  "title": "Supremacy",
  "author": "Muse",
  "timeLength": "4:55",
  "genre": "Alternative rock"
}'
```

Получение всех музыкальных композиций

```bash
curl --request GET \
  --url http://localhost:8089/api/songs/
```

Поиск композиций по части исполнителя или названию композиции

```bash
curl --request GET \
--url http://localhost:8089/api/songs/search/us 
```

- `us` - поисковый запрос
