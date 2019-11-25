package marviq.ogel.converter;

import marviq.ogel.dto.Machine2x2Dto;
import marviq.ogel.entity.Machine2x2;
import org.springframework.stereotype.Component;

@Component
public class Machine2x2Converter {

    public Machine2x2Dto convert(Machine2x2 sourceOfData) {
        Machine2x2Dto machine2x2Dto = new Machine2x2Dto();
        machine2x2Dto.setStartDate(sourceOfData.getStartDate());
        machine2x2Dto.setEndDate(sourceOfData.getEndDate());
        machine2x2Dto.setGrossProduction(sourceOfData.getGrossProduction());
        machine2x2Dto.setScrap(sourceOfData.getScrap());
        machine2x2Dto.setCoreTemperature(sourceOfData.getCoreTemperature());
        return machine2x2Dto;
    }

    public Machine2x2 convert(Machine2x2Dto sourceOfData) {
        Machine2x2 machine2x2 = new Machine2x2();
        machine2x2.setStartDate(sourceOfData.getStartDate());
        machine2x2.setEndDate(sourceOfData.getEndDate());
        machine2x2.setGrossProduction(sourceOfData.getGrossProduction());
        machine2x2.setScrap(sourceOfData.getScrap());
        machine2x2.setCoreTemperature(sourceOfData.getCoreTemperature());
        return machine2x2;
    }

}
