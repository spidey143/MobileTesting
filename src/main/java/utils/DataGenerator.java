package utils;

import models.RequestModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static final String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final Random RANDOM = new Random();
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final List<String> SERVICES = List.of(
            "Предоставление источников электропитания",
            "Буксировка ВС",
            "Предоставление спецтехники и оборудования для погрузочно-разгрузочных работ",
            "Предоставление стремянок/трапов",
            "Заправка сжатым газом"

    );
    private static final List<String> CUSTOMERS = List.of(
            "Авиакомпания \"ЮТэйр\"",
            "АК \"Победа\"",
            "АЗУР эйр",
            "Автокомпания \"Россия\"",
            "АК \"ИрАэро\""
    );
    private static final List<String> OFFICES = List.of(
            "Офис UTV",
            "Офис UTG",
            "Центральный офис",
            "Офис Домодедово",
            "Офис Шереметьево"
    );
    private static final List<String> JOB_VIEWS = List.of(

    );
    private static final List<String> VS_NUMBERS = List.of();

    public static String generateRandomString(Integer length) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < length; i++)
            resultStr.append(russianAlphabet.charAt(RANDOM.nextInt(russianAlphabet.length())));
        return resultStr.toString();
    }

    public static RequestModel generateRequest() {
        return RequestModel.builder()
                .service(SERVICES.get(RANDOM.nextInt(SERVICES.size())))
                .customer(CUSTOMERS.get(RANDOM.nextInt(CUSTOMERS.size())))
                .office(OFFICES.get(RANDOM.nextInt(OFFICES.size())))
                .startDate(LocalDate.now().format(DATE_TIME_FORMATTER))
                .endDate(LocalDate.now().plusDays(1).format(DATE_TIME_FORMATTER))
                .startTime(LocalTime.now().format(TIME_FORMATTER))
                .endTime(LocalTime.now().format(TIME_FORMATTER))
                .numberVs("")
                .flightNumber("")
                .jobView("")
                .count(RANDOM.nextInt())
                .comment(generateRandomString(10))
                .additionalInfo(generateRandomString(10))
                .build();
    }
}
