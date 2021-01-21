Приложение для получение GIF изображения в зависимости от разницы курсов валют 

Код курса валюты задается в настройках приложения в src/main/resources/application.yml в формате: RUB, EUR.
Реализован запуск приложения с использованием секретных ключей в отдельном файле application.yml, который находится в корне проекта. 
В тестовых целях приватные ключи предварительно установлены  

Для запуска приложения необходимо выполнить следующие команды:

1. git clone https://github.com/VladimirTitov4/GifLoader.git
2. cd GifLoader/
3. gradle clean build
4. docker-compose up -d

Использованные технологии:
- Java 8
- Spring Boot 2
- Feign
- Gradle
- Lombok
