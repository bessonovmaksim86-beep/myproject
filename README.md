# MyProject

MyProject — веб-приложение для учета финансовых данных, категорий, транзакций и генерации отчетов в PDF/Excel.

## Возможности
- Ввод и просмотр доходов/расходов
- Управление категориями
- Дашборд с метриками и графиками
- Генерация отчетов за месяц, квартал и год
- Экспорт отчетов в PDF и Excel
- REST API для интеграций и AJAX
- Тесты JUnit, Mockito и MockMvc
- Обработка ошибок и валидация форм

## Технологии
- Java 11
- Spring Boot 2.5+
- Spring MVC
- Spring Data JPA
- Spring JDBC
- PostgreSQL
- Thymeleaf
- Bootstrap
- Chart.js
- iText
- Apache POI
- Maven

## Запуск
### Требования
- Java 11+
- Maven 3.6+
- PostgreSQL

### Создание базы
```sql
CREATE DATABASE myproject;
CREATE USER myproject WITH PASSWORD 'myproject';
GRANT ALL PRIVILEGES ON DATABASE myproject TO myproject;
