package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestModel {
    private String service;
    private String customer;
    private String office;
    private String typeVs;
    private String numberVs;
    private String flightNumber;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String platform;
    private String parkingPlace;
    private String jobView;
    private Integer count;
    private String comment;
    private String additionalInfo;
}
