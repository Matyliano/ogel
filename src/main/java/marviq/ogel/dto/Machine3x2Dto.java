package marviq.ogel.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Machine3x2Dto {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double grossProduction;

    private Double scrap;

    private Double coreTemperature;
}
