package utils;

import models.RequestModel;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    private List<String> services = List.of(
            ""
    );
    private List<String> customers = List.of(

    );
    private List<String> offices = List.of(

    );


    public static RequestModel generateRequest() {
        return RequestModel.builder()
                .service("")
                .customer("")
                .office("")
                .startDate("")
                .endDate("")
                .startTime("")
                .endTime("")
                .numberVs("")
                .flightNumber("")
                .jobView("")
                .count(10)
                .comment("")
                .additionalInfo("")
                .build();
    }
}
