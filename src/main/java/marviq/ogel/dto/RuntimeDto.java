package marviq.ogel.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RuntimeDto {

    private String machineName;

    private LocalDateTime dateTime;

    private int isRunning;

}
