package marviq.ogel.converter;

import marviq.ogel.dto.Machine3x2Dto;
import marviq.ogel.entity.Machine3x2;
import org.springframework.stereotype.Component;

@Component
public class Machine3x2Converter {

    public Machine3x2Dto convert(Machine3x2 sourceOfData) {
        Machine3x2Dto machine3x2Dto = new Machine3x2Dto();
        machine3x2Dto.setStartDate(sourceOfData.getStartDate());
        machine3x2Dto.setEndDate(sourceOfData.getEndDate());
        machine3x2Dto.setGrossProduction(sourceOfData.getGrossProduction());
        machine3x2Dto.setScrap(sourceOfData.getScrap());
        machine3x2Dto.setCoreTemperature(sourceOfData.getCoreTemperature());
        return machine3x2Dto;
    }

    public Machine3x2 convert(Machine3x2Dto sourceOfData) {
        Machine3x2 machine3x2 = new Machine3x2();
        machine3x2.setStartDate(sourceOfData.getStartDate());
        machine3x2.setEndDate(sourceOfData.getEndDate());
        machine3x2.setGrossProduction(sourceOfData.getGrossProduction());
        machine3x2.setScrap(sourceOfData.getScrap());
        machine3x2.setCoreTemperature(sourceOfData.getCoreTemperature());
        return machine3x2;
    }

}
