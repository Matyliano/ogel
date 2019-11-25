package marviq.ogel.converter;

import marviq.ogel.dto.Machine4x2Dto;
import marviq.ogel.entity.Machine4x2;
import org.springframework.stereotype.Component;

@Component
public class Machine4x2Converter {

    public Machine4x2Dto convert(Machine4x2 sourceOfData) {
        Machine4x2Dto machine4x2Dto = new Machine4x2Dto();
        machine4x2Dto.setStartDate(sourceOfData.getStartDate());
        machine4x2Dto.setEndDate(sourceOfData.getEndDate());
        machine4x2Dto.setGrossProduction(sourceOfData.getGrossProduction());
        machine4x2Dto.setScrap(sourceOfData.getScrap());
        machine4x2Dto.setCoreTemperature(sourceOfData.getCoreTemperature());
        return machine4x2Dto;
    }

    public Machine4x2 convert(Machine4x2Dto sourceOfData) {
        Machine4x2 machine4x2 = new Machine4x2();
        machine4x2.setStartDate(sourceOfData.getStartDate());
        machine4x2.setEndDate(sourceOfData.getEndDate());
        machine4x2.setGrossProduction(sourceOfData.getGrossProduction());
        machine4x2.setScrap(sourceOfData.getScrap());
        machine4x2.setCoreTemperature(sourceOfData.getCoreTemperature());
        return machine4x2;
    }

}
