# BTS-test-task

# Readme

## Для начала работы с приложением
* Скопируйте этот репозиторий к себе на компьютер
* Создайте базу данных в PostgresSQL
* Изменить настройки в *application.properties* файле на ваши значение где: <br> [database name] - название вашей бд
    <br> [username] - ваш логин для подключения к бд
    <br> [password] - ваш пароль для подключения к бд
## Запуск приложения
* Откройте терминал(консоль) и перейдите в директорию с файлом *pom.xml*
* Выполните команду *mvn clean install*
* Затем выполните команду *mvn spring-boot:start*, после этого приложение должно запуститьсяю <br>
  После запуска приложения необходимо самостоятельно заполнить справочник со списком технологий(таблица technologies в бд)

## Работа с приложением
 Все адреса для работы с приложением будут начинаться с *http://localhost:8080/*
<br> Далее вам будут доступны следующие адреса:
* */resumes* - для просмотра списка всех резюме
* */resumes/new* - для заполнения анкеты и создания нового резюме
* */resumes/firstCategory* - для просмотра списка резюме первой очередности
* */resumes/secondCategory* - для просмотра списка резюме второй очередности
* */resumes/thirdCategory* - для просмотра списка резюме третьей очередности
* */resumes/[id]* - для просмотра резюме отдельного кандидата, где [id] - это id кандидата]
* для остановки работы приложения необходимо выполнить команду *mvn spring-boot:stop*

Также, при просмотре списков резюме, будет доступна возможность перехода, для просмотре отельного кандидата по нажатию на его ФИО.

