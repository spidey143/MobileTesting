package utils;

import models.RequestModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final Random RANDOM = new Random();
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final List<String> CUSTOMERS = List.of(
            "Авиакомпания \"ЮТэйр\"",
            "АК \"Победа\"",
            "АЗУР эйр",
            "Авиакомпания \"Россия\"",
            "АК \"ИрАэро\""
    );

    private static final List<String> VS_TYPES = List.of(
            "Aerospatiale (Nord) 262",
            "Aerospatiale (Sud Aviation) Se.210 Caravelle",
            "Aerospatiale SN.601.Corvette",
            "Agusta A109",
            "Airbus A300"
    );

    private static final List<String> PARKING_PLACES = List.of(
            "02 (Т)",
            "03 (Т)",
            "04 (Т)",
            "05 (Т)",
            "10 (ТЭ)"
    );
    private static final List<String> PLATFORMS = List.of(
            "ВНК - Перрон1",
            "ВНК - Перрон4"
    );

    public static String generateRandomString(Integer length) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < length; i++)
            resultStr.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        return resultStr.toString();
    }

    public static RequestModel generateRequest() {
        return RequestModel.builder()
                .service("Предоставление спецтехники и оборудования для погрузочно-разгрузочных работ")
                .customer(CUSTOMERS.get(RANDOM.nextInt(CUSTOMERS.size())))
                .startDate(LocalDate.now().format(DATE_FORMATTER))
                .endDate(LocalDate.now().plusDays(1).format(DATE_FORMATTER))
                .startTime(LocalTime.now().format(TIME_FORMATTER))
                .endTime(LocalTime.now().format(TIME_FORMATTER))
                .flightNumber("testreys" + RANDOM.nextInt(100))
                .jobView("Предоставление багажной тележки")
                .platform(PLATFORMS.get(RANDOM.nextInt(PLATFORMS.size())))
                .parkingPlace(PARKING_PLACES.get(RANDOM.nextInt(PARKING_PLACES.size())))
                .typeVs(VS_TYPES.get(RANDOM.nextInt(VS_TYPES.size())))
                .count(RANDOM.nextInt(100))
                .comment(generateRandomString(10))
                .additionalInfo(generateRandomString(10))
                .build();
    }
}
