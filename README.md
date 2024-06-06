# Требования:
Чтобы запустить тесты, должны быть установлены следующие компоненты:
  1. Node.js;
  2. Appium;
  3. UiAutomator2 Driver;
  4. Android Studio;
  5. Maven;
  6. Java 18;
  7. Inteliji IDEA.
  
Если у вас не устанавлены данные компоненты ниже будут предоставлены варианты их установки. 
# Варианты установки
  ## Node.js
  Для установки Node.js нужно перейти на официальный сайт <https://nodejs.org/en/download> и нажать кнопку "Download Node.js"; 
  ## Appium
  Для установки Appium потребуется выполнить следующую команду:
  ```shell
  npm i -g appium
  ```
  ## UiAutomator2 Driver
  Для установки UiAutomator2 Driver потребуется выполнить следующую команду:
  ```shell
  appium driver install uiautomator2
  ```
  ## Android Studio
  Для установки Android Studio необходимо перейти на официальный сайт <https://developer.android.com/studio> и нажать кнопку "Download Android Studio"
  ## Maven
  Для установки Maven необходимо перейти на ссылку для скачивания архива <https://dlcdn.apache.org/maven/maven-3/3.9.7/binaries/apache-maven-3.9.7-bin.zip>, далее разархивировать данный архив в корень диска C,
  перейти в дополнительные параметры системы -> переменные среды -> два раза кликнуть на "Path" в разеделе системные переменные -> нажать кнопку "Обзор" -> перейти в папку с maven которя лежит в корне C -> выбрать папку bin -> кликнуть на кнопку "Окей" и закрыть все ранее открытые окна.
  Теперь можно проверить что на компьютере установлен maven и он виден:
  ```shell
  mvn --version
  ```
  ## Java
  Для установки Java необходимо перейти сайт <https://www.techspot.com/downloads/2017-java-jdk-18.html>, выбрать платформу и перейте и к скачиванию. 
  ## IntelliJ IDEA
  Для уставноки IntelliJ IDEA необходимо перейти на сайт <https://www.jetbrains.com/idea/download/?section=windows>, рекомендуется выбрать версию Community и кликнуть на кнопку "Dowload".
# Запуск тестов
Для запуска тестов необхожимо выполнить следующую команду:
```shell
mvn clean test
```
# Отчет о результате тестов
Для получения отчета о результате тестов нужно выполнить следующую команду:
```shell
allure serve .\target\allure-results
```
