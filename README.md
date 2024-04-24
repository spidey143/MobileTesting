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
  4. Для установки Android Studio необходимо перейти на официальный сайт <https://developer.android.com/studio> и нажать кнопку "Download Android Studio"
  5. Maven poka skipaem
  6. java skip
  7. intel skip
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
